package site.metacoding.animalprojectfrontend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.animalprojectfrontend.domain.post.Post;
import site.metacoding.animalprojectfrontend.domain.post.PostRepository;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    public void 글쓰기(Post post) {
        postRepository.save(post);
    }

    public List<Post> 글목록보기(String board) {
        List<Post> postOp = postRepository.findByBoard(board);
        return postOp;
    }
}
