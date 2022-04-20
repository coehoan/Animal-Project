package site.metacoding.animalprojectfrontend.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import site.metacoding.animalprojectfrontend.domain.post.Post;
import site.metacoding.animalprojectfrontend.domain.user.User;
import site.metacoding.animalprojectfrontend.service.PostService;
import site.metacoding.animalprojectfrontend.web.api.dto.post.AdoptPostRespDto;
import site.metacoding.animalprojectfrontend.web.api.dto.post.FreePostRespDto;
import site.metacoding.animalprojectfrontend.web.api.dto.post.MainPostRespDto;
import site.metacoding.animalprojectfrontend.web.api.dto.post.PageRespDto;
import site.metacoding.animalprojectfrontend.web.api.dto.post.PostDetailRespDto;
import site.metacoding.animalprojectfrontend.web.api.dto.post.RegionPostRespDto;

@RequiredArgsConstructor
@Controller
public class PostController {

    private final PostService postService;
    private final HttpSession session;

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
    public String adoptPage(@RequestParam(defaultValue = "0") Integer page, Model model, Pageable pageable) {
        String board = "adopt";
        PageRequest pr = PageRequest.of(page, 10, Sort.by(Direction.DESC, "id"));

        Page<Post> posts = postService.글목록보기(board, pr);
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

        List<Integer> pageList = new ArrayList<>();
        for (int i = 0; i < posts.getTotalPages(); i++) {
            pageList.add(i);
        }

        PageRespDto pageRespDto = new PageRespDto();
        pageRespDto.setTotal(pageList);
        pageRespDto.setHasNext(posts.hasNext());
        pageRespDto.setHasPrevious(posts.hasPrevious());

        model.addAttribute("posts", adoptPostRespDtoList);
        model.addAttribute("pages", pageRespDto);
        model.addAttribute("prevPage", page - 1);
        model.addAttribute("nextPage", page + 1);
        return "blog/adoptboard";
    }

    // 지역별 게시판
    @GetMapping("/blog/region")
    public String regionPage(@RequestParam(defaultValue = "0") Integer page, Model model, Pageable pageable) {
        String board = "region";
        PageRequest pr = PageRequest.of(page, 10, Sort.by(Direction.DESC, "id"));

        Page<Post> posts = postService.글목록보기(board, pr);
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

        List<Integer> pageList = new ArrayList<>();
        for (int i = 0; i < posts.getTotalPages(); i++) {
            pageList.add(i);
        }

        PageRespDto pageRespDto = new PageRespDto();
        pageRespDto.setTotal(pageList);
        pageRespDto.setHasNext(posts.hasNext());
        pageRespDto.setHasPrevious(posts.hasPrevious());

        model.addAttribute("posts", regionPostRespDtoList);
        model.addAttribute("pages", pageRespDto);
        model.addAttribute("prevPage", page - 1);
        model.addAttribute("nextPage", page + 1);
        return "blog/regionboard";
    }

    // 자유게시판
    @GetMapping("/blog/free")
    public String freePage(@RequestParam(defaultValue = "0") Integer page, Model model, Pageable pageable) {
        String board = "free";
        PageRequest pr = PageRequest.of(page, 10, Sort.by(Direction.DESC, "id"));

        Page<Post> posts = postService.글목록보기(board, pr);

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

        List<Integer> pageList = new ArrayList<>();
        for (int i = 0; i < posts.getTotalPages(); i++) {
            pageList.add(i);
        }

        PageRespDto pageRespDto = new PageRespDto();
        pageRespDto.setTotal(pageList);
        pageRespDto.setHasNext(posts.hasNext());
        pageRespDto.setHasPrevious(posts.hasPrevious());

        model.addAttribute("posts", freePostRespDtoList);
        model.addAttribute("pages", pageRespDto);
        model.addAttribute("prevPage", page - 1);
        model.addAttribute("nextPage", page + 1);
        return "blog/freeboard";
    }

    // 상세보기
    @GetMapping("/blog/post/{id}")
    public String adoptboardPost(@PathVariable Integer id, Model model) {

        Post postOp = postService.글상세보기(id);

        Integer updateView = postOp.getView() + 1;

        PostDetailRespDto postDetailRespDto = new PostDetailRespDto();
        postDetailRespDto.setId(postOp.getId());
        postDetailRespDto.setTitle(postOp.getTitle());
        postDetailRespDto.setContent(postOp.getContent());
        postDetailRespDto.setCreateDate(postOp.getCreateDate());
        postDetailRespDto.setUser(postOp.getUser());
        postDetailRespDto.setView(updateView);
        postDetailRespDto.setRecommended(postOp.getRecommended());

        postService.조회수증가(updateView, id);

        // User principal = (User) session.getAttribute("principal");

        model.addAttribute("posts", postDetailRespDto);
        // model.addAttribute("principal", principal.getId());

        return "/blog/post/postDetail";
    }

}
