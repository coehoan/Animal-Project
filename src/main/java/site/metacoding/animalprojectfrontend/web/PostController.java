package site.metacoding.animalprojectfrontend.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import site.metacoding.animalprojectfrontend.domain.post.Post;
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

    // 상세검색
    @GetMapping("/blog/post/search")
    public String search(@RequestParam(defaultValue = "0") Integer page, @RequestParam(value = "board") String board,
            String region, String type, Model model,
            Pageable pageable) {

        PageRequest pr = PageRequest.of(page, 10);

        // 요청값 없을 때 redirect
        if (region.equals("all") && type.equals("all")) {
            String redirect = "redirect:/blog/" + board;
            return redirect;
        }
        // 입양후기 지역만 선택했을 때
        if (region != "all" && type.equals("all")) {
            Page<Post> posts = postService.지역별보기(board, region, pr);
            List<AdoptPostRespDto> adoptPostRespDtoList = new ArrayList<AdoptPostRespDto>();

            for (Post postList : posts) {
                AdoptPostRespDto postRespDto = new AdoptPostRespDto();

                postRespDto.setId(postList.getId());
                postRespDto.setRegion(postList.getRegion());
                postRespDto.setType(postList.getType());
                postRespDto.setTitle(postList.getTitle());
                postRespDto.setUsername(postList.getUser().getUsername());
                postRespDto.setCreateDate(postList.getCreateDate());
                postRespDto.setView(postList.getView());
                postRespDto.setRecommended(postList.getRecommended());
                adoptPostRespDtoList.add(postRespDto);
                System.out.println("이름 --> " + postList.getUser().getUsername());
            }
            // System.out.println("게시글 최종 리스트 --> " + adoptPostRespDtoList);
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

            return "/blog/adoptboard";
        }
        // 입양후기 종류만 선택했을 때
        else if (region.equals("all") && type != "all") {
            Page<Post> posts = postService.종류별보기(board, type, pr);
            List<AdoptPostRespDto> adoptPostRespDtoList = new ArrayList<AdoptPostRespDto>();

            for (Post postList : posts) {
                AdoptPostRespDto postRespDto = new AdoptPostRespDto();

                postRespDto.setId(postList.getId());
                postRespDto.setRegion(postList.getRegion());
                postRespDto.setType(postList.getType());
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

            return "/blog/adoptboard";
        }
        // 입양후기 지역, 종류 모두 선택했을 때
        else if (region != "all" && type != "all") {
            Page<Post> posts = postService.지역종류별보기(board, region, type, pr);
            List<AdoptPostRespDto> adoptPostRespDtoList = new ArrayList<AdoptPostRespDto>();

            for (Post postList : posts) {
                AdoptPostRespDto postRespDto = new AdoptPostRespDto();

                postRespDto.setId(postList.getId());
                postRespDto.setRegion(postList.getRegion());
                postRespDto.setType(postList.getType());
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

            return "/blog/adoptboard";
        }

        return null;
    }

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
        PageRequest pr = PageRequest.of(page, 10);

        Page<Post> posts = postService.글목록보기(board, pr);
        List<AdoptPostRespDto> adoptPostRespDtoList = new ArrayList<AdoptPostRespDto>();

        for (Post postList : posts) {
            AdoptPostRespDto postRespDto = new AdoptPostRespDto();

            postRespDto.setId(postList.getId());
            postRespDto.setRegion(postList.getRegion());
            postRespDto.setType(postList.getType());
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
        PageRequest pr = PageRequest.of(page, 10);

        Page<Post> posts = postService.글목록보기(board, pr);
        List<RegionPostRespDto> regionPostRespDtoList = new ArrayList<RegionPostRespDto>();

        for (Post postList : posts) {
            RegionPostRespDto postRespDto = new RegionPostRespDto();

            postRespDto.setId(postList.getId());
            postRespDto.setRegion(postList.getRegion());
            postRespDto.setCategory(postList.getCategory());
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
        PageRequest pr = PageRequest.of(page, 10);

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

    // 글쓰기
    @GetMapping("/s/blog/writeForm")
    public String writeForm() {

        return "/blog/writeForm";
    }

}
