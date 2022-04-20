package site.metacoding.animalprojectfrontend.service;

import java.util.List;

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
}
