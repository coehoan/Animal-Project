package site.metacoding.animalprojectfrontend.web.api;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.animalprojectfrontend.domain.post.Post;
import site.metacoding.animalprojectfrontend.domain.user.User;
import site.metacoding.animalprojectfrontend.service.PostService;
import site.metacoding.animalprojectfrontend.web.api.dto.ResponseDto;
import site.metacoding.animalprojectfrontend.web.api.dto.post.RecReqDto;
import site.metacoding.animalprojectfrontend.web.api.dto.post.SearchReqDto;
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
        System.out.println("컨트롤러 접근 - " + RecReqDto);
        postService.추천수증감(RecReqDto.getRecommended(), RecReqDto.getId());
        return new ResponseDto<>(1, "성공", null);

    }
}

