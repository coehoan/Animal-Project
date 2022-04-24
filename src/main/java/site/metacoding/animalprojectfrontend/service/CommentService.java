package site.metacoding.animalprojectfrontend.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.animalprojectfrontend.domain.comment.Comment;
import site.metacoding.animalprojectfrontend.domain.comment.CommentRepository;
import site.metacoding.animalprojectfrontend.domain.post.Post;
import site.metacoding.animalprojectfrontend.domain.post.PostRepository;
import site.metacoding.animalprojectfrontend.domain.user.User;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Transactional
    public void 댓글삭제(Integer id, User principal) {
        Optional<Comment> commentOp = commentRepository.findById(id);

        if (commentOp.isPresent()) {
            Comment commentEntity = commentOp.get();
            if (principal.getId() != commentEntity.getUser().getId()) {
                throw new RuntimeException("권한이 없습니다.");
            }

        } else {
            throw new RuntimeException("해당 댓글이 없습니다.");
        }

        commentRepository.deleteById(id);
    }

    @Transactional
    public void 댓글쓰기(Comment comment, Integer id) {
        Optional<Post> postOp = postRepository.findById(id);
        if (postOp.isPresent()) {
            Post postEntity = postOp.get();
            comment.setPost(postEntity);
        } else {
            throw new RuntimeException("게시글이 존재하지 않습니다.");
        }
        commentRepository.save(comment);
    }
}
