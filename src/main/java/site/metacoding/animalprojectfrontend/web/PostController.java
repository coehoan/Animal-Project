package site.metacoding.animalprojectfrontend.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.animalprojectfrontend.domain.post.Post;
import site.metacoding.animalprojectfrontend.service.PostService;
import site.metacoding.animalprojectfrontend.web.api.dto.post.AdoptPostRespDto;

@RequiredArgsConstructor
@Controller
public class PostController {

    private final PostService postService;

    // 입양후기 게시판
    @GetMapping("/blog/adopt")
    public String adoptPage(Model model) {
        String board = "adopt";
        List<Post> posts = postService.글목록보기(board);
        List<AdoptPostRespDto> postRespDtoList = new ArrayList<AdoptPostRespDto>();

        for (Post postList : posts) {
            AdoptPostRespDto postRespDto = new AdoptPostRespDto();
            String region = postList.getRegion();
            if (region.equals("seoul"))
                region = "서울";
            else if (region.equals("gyeonggi"))
                region = "경기";
            else if (region.equals("incheon"))
                region = "인천";
            else if (region.equals("gangwon"))
                region = "강원";
            else if (region.equals("sejong"))
                region = "세종";
            else if (region.equals("chungbuk"))
                region = "충북";
            else if (region.equals("chungnam"))
                region = "충남";
            else if (region.equals("daejeon"))
                region = "대전";
            else if (region.equals("jeonbuk"))
                region = "전북";
            else if (region.equals("jeonnam"))
                region = "전남";
            else if (region.equals("gwangju"))
                region = "광주";
            else if (region.equals("gyeongbuk"))
                region = "경북";
            else if (region.equals("daegu"))
                region = "대구";
            else if (region.equals("gyeongnam"))
                region = "경남";
            else if (region.equals("ulsan"))
                region = "울산";
            else if (region.equals("busan"))
                region = "부산";
            else if (region.equals("jeju"))
                region = "제주";

            String type = postList.getType();
            if (type.equals("dog"))
                type = "강아지";
            else if (type.equals("cat"))
                type = "고양이";
            else if (type.equals("etc"))
                type = "기타";

            postRespDto.setId(postList.getId());
            postRespDto.setRegion(region);
            postRespDto.setType(type);
            postRespDto.setTitle(postList.getTitle());
            postRespDto.setUsername(postList.getUser().getUsername());
            postRespDto.setCreateDate(postList.getCreateDate());
            postRespDto.setView(postList.getView());
            postRespDto.setRecommended(postList.getRecommended());
            postRespDtoList.add(postRespDto);
        }

        // System.out.println("======" + posts);
        // System.out.println("======**" + posts.get(0).getUser().getUsername());
        model.addAttribute("posts", postRespDtoList);
        return "blog/adoptboard";
    }

    // 지역별 게시판
    @GetMapping("/blog/region")
    public String regionPage() {
        return "blog/regionboard";
    }

    // 자유게시판
    @GetMapping("/blog/free")
    public String freePage() {
        return "blog/freeboard";
    }

}
