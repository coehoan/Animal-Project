package site.metacoding.animalprojectfrontend.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.animalprojectfrontend.config.post.Post;
import site.metacoding.animalprojectfrontend.service.PostService;
import site.metacoding.animalprojectfrontend.web.api.dto.post.AdoptPostRespDto;
import site.metacoding.animalprojectfrontend.web.api.dto.post.FreePostRespDto;
import site.metacoding.animalprojectfrontend.web.api.dto.post.MainPostRespDto;
import site.metacoding.animalprojectfrontend.web.api.dto.post.RegionPostRespDto;

@RequiredArgsConstructor
@Controller
public class PostController {

    private final PostService postService;

    // 블로그 메인 게시판
    @GetMapping("/blog")
    public String blog(Model model) {
        List<String> board = new ArrayList<>();
        board.add("adopt");
        board.add("region");
        board.add("free");
        for (String postList : board) {
            List<MainPostRespDto> mainPostRespDtoList = new ArrayList<MainPostRespDto>();
            List<Post> posts = postService.인기글보기(postList);
            if (posts.size() != 3)
                throw new RuntimeException("사이즈 오류");

            for (Post postLists : posts) {
                MainPostRespDto postRespDto = new MainPostRespDto();
                postRespDto.setId(postLists.getId());
                postRespDto.setTitle(postLists.getTitle());
                postRespDto.setUsername(postLists.getUser().getUsername());
                postRespDto.setCreateDate(postLists.getCreateDate());
                mainPostRespDtoList.add(postRespDto);
            }
            if (mainPostRespDtoList.size() != 3)
                continue;

            if (mainPostRespDtoList != null && posts != null) {
                if (posts.stream().filter(x -> x.getBoard().equals("adopt")).count() > 0) {
                    model.addAttribute("adopts", mainPostRespDtoList);
                } else if (posts.stream().filter(x -> x.getBoard().equals("region")).count() > 0) {
                    model.addAttribute("regions", mainPostRespDtoList);
                } else if (posts.stream().filter(x -> x.getBoard().equals("free")).count() > 0) {
                    model.addAttribute("frees", mainPostRespDtoList);
                }
            }
        }
        return "blog/blogMain";
    }

    // 입양후기 게시판
    @GetMapping("/blog/adopt")
    public String adoptPage(Model model) {
        String board = "adopt";
        List<Post> posts = postService.글목록보기(board);
        List<AdoptPostRespDto> adoptPostRespDtoList = new ArrayList<AdoptPostRespDto>();

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
            adoptPostRespDtoList.add(postRespDto);
        }

        // System.out.println("======" + posts);
        // System.out.println("======**" + posts.get(0).getUser().getUsername());
        model.addAttribute("posts", adoptPostRespDtoList);
        return "blog/adoptboard";
    }

    // 지역별 게시판
    @GetMapping("/blog/region")
    public String regionPage(Model model) {
        String board = "region";
        List<Post> posts = postService.글목록보기(board);
        List<RegionPostRespDto> regionPostRespDtoList = new ArrayList<RegionPostRespDto>();

        for (Post postList : posts) {
            RegionPostRespDto postRespDto = new RegionPostRespDto();
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

            String category = postList.getCategory();
            if (category.equals("ask"))
                category = "질문";
            else if (category.equals("food"))
                category = "맛집";
            else if (category.equals("info"))
                category = "정보";

            postRespDto.setId(postList.getId());
            postRespDto.setRegion(region);
            postRespDto.setCategory(category);
            postRespDto.setTitle(postList.getTitle());
            postRespDto.setUsername(postList.getUser().getUsername());
            postRespDto.setCreateDate(postList.getCreateDate());
            postRespDto.setView(postList.getView());
            postRespDto.setRecommended(postList.getRecommended());
            regionPostRespDtoList.add(postRespDto);
        }

        // System.out.println("======" + posts);
        // System.out.println("======**" + posts.get(0).getUser().getUsername());
        model.addAttribute("posts", regionPostRespDtoList);
        return "blog/regionboard";
    }

    // 자유게시판
    @GetMapping("/blog/free")
    public String freePage(Model model) {
        String board = "free";
        List<Post> posts = postService.글목록보기(board);
        List<FreePostRespDto> freePostRespDtoList = new ArrayList<FreePostRespDto>();

        for (Post postList : posts) {
            FreePostRespDto postRespDto = new FreePostRespDto();

            postRespDto.setId(postList.getId());
            postRespDto.setTitle(postList.getTitle());
            postRespDto.setUsername(postList.getUser().getUsername());
            postRespDto.setCreateDate(postList.getCreateDate());
            postRespDto.setView(postList.getView());
            postRespDto.setRecommended(postList.getRecommended());
            freePostRespDtoList.add(postRespDto);
        }

        // System.out.println("======" + posts);
        // System.out.println("======**" + posts.get(0).getUser().getUsername());
        model.addAttribute("posts", freePostRespDtoList);
        return "blog/freeboard";
    }

}
