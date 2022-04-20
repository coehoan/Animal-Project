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
        List<Post> postEntity = postRepository.findByBoard(board);
        return postEntity;
    }

    public List<Post> 인기글보기(String board) {
        List<Post> postEntity = postRepository.findHotPost(board);
        return postEntity;
    }

    public Post 글상세보기(Integer id) {
        Optional<Post> postOp = postRepository.findById(id);
        if (postOp.isPresent()) {
            Post postEntity = postOp.get();
            return postEntity;
        } else
            throw new RuntimeException("게시글이 없습니다.");
    }

    public void 조회수증가(Integer updateView, Integer id) {
        postRepository.viewCount(updateView, id);
    }

    public void 추천수증감(Integer recommended, Integer id) {
        System.out.println("글 아이디 --> " + id + "추천수 --> " + recommended);
        postRepository.recCount(recommended, id);
    }
}
