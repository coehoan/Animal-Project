package site.metacoding.animalprojectfrontend.web.api;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.animalprojectfrontend.domain.post.Post;
import site.metacoding.animalprojectfrontend.domain.user.User;
import site.metacoding.animalprojectfrontend.service.PostService;
import site.metacoding.animalprojectfrontend.web.api.dto.ResponseDto;
import site.metacoding.animalprojectfrontend.web.api.dto.post.RecReqDto;
import site.metacoding.animalprojectfrontend.web.api.dto.post.UpdateDto;
import site.metacoding.animalprojectfrontend.web.api.dto.post.WriteDto;

@RequiredArgsConstructor
@RestController
public class PostApiController {

    private final PostService postService;
    private final HttpSession session;

    // 블로그 글쓰기
    @PostMapping("/s/blog/write")
    public ResponseDto<?> write(@RequestBody WriteDto writeDto) {

        User principal = (User) session.getAttribute("principal");
        Post post = writeDto.toEntity(principal);

        postService.글쓰기(post);
        return new ResponseDto<>(1, "성공", null);
    }

    // 추천수 증감
    @PostMapping("/s/post/{id}")
    public ResponseDto<?> updateRec(@RequestBody RecReqDto RecReqDto) {
        postService.추천수증감(RecReqDto.getRecommended(), RecReqDto.getId());
        return new ResponseDto<>(1, "성공", null);

    }

    // 게시글 삭제
    @DeleteMapping("/s/post/delete/{id}")
    public ResponseDto<?> deleteById(@PathVariable Integer id) {
        postService.게시글삭제(id);
        return new ResponseDto<>(1, "성공", null);
    }

    // 게시글 수정
    @PutMapping("/s/post/update/{id}")
    public ResponseDto<?> updateById(@RequestBody UpdateDto updateDto) {
        Integer id = updateDto.getId();
        String title = updateDto.getTitle();
        String content = updateDto.getContent();
        postService.게시글수정(id, title, content);
        return new ResponseDto<>(1, "성공", null);
    }
}
