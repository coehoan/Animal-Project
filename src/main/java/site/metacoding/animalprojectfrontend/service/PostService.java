package site.metacoding.animalprojectfrontend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.animalprojectfrontend.domain.post.Post;
import site.metacoding.animalprojectfrontend.domain.post.PostRepository;
import site.metacoding.animalprojectfrontend.web.api.dto.post.UpdateDto;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    public void 글쓰기(Post post) {
        postRepository.save(post);
    }

    public Page<Post> 글목록보기(String board, Pageable page) {
        Page<Post> postEntity = postRepository.findByBoard(board, page);
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

    public Page<Post> 지역별보기(String board, String region, Pageable page) {
        Page<Post> postEntity = postRepository.findByBoardAndRegion(board, region, page);
        return postEntity;
    }

    public Page<Post> 종류별보기(String board, String type, Pageable page) {
        Page<Post> postEntity = postRepository.findByBoardAndType(board, type, page);
        return postEntity;
    }

    public Page<Post> 지역종류별보기(String board, String region, String type, Pageable page) {
        Page<Post> postEntity = postRepository.findByBoardAndRegionANDType(board, region, type, page);
        return postEntity;
    }

    public Page<Post> 게시글검색(String board, String query, Pageable page, String searchBy) {
        if (searchBy == null)
            return null;

        Page<Post> postEntity = null;
        if (searchBy.equals("title"))
            postEntity = postRepository.findByBoardSearchByTitle(board, query, page);
        else if (searchBy.equals("content"))
            postEntity = postRepository.findByBoardSearchByContent(board, query, page);
        else if (searchBy.equals("username"))
            postEntity = postRepository.findByBoardSearchByUsername(board, query, page);
        return postEntity;
    }

    public void 조회수증가(Integer updateView, Integer id) {
        postRepository.viewCount(updateView, id);
    }

    public void 추천수증감(Integer recommended, Integer id) {
        postRepository.recCount(recommended, id);
    }

    public void 게시글삭제(Integer id) {
        postRepository.deleteById(id);
    }

    public void 게시글수정(Integer id, String title, String content) {
        postRepository.updateById(id, title, content);
    }
}
