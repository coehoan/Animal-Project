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
import site.metacoding.animalprojectfrontend.domain.comment.Comment;
import site.metacoding.animalprojectfrontend.domain.post.Post;
import site.metacoding.animalprojectfrontend.domain.user.User;
import site.metacoding.animalprojectfrontend.service.PostService;
import site.metacoding.animalprojectfrontend.web.api.dto.comment.CommentRespDto;
import site.metacoding.animalprojectfrontend.web.api.dto.post.DetailSearchRespDto;
import site.metacoding.animalprojectfrontend.web.api.dto.post.FreePostRespDto;
import site.metacoding.animalprojectfrontend.web.api.dto.post.MainPostRespDto;
import site.metacoding.animalprojectfrontend.web.api.dto.post.PageRespDto;
import site.metacoding.animalprojectfrontend.web.api.dto.post.PostDetailRespDto;
import site.metacoding.animalprojectfrontend.web.api.dto.post.RegionPostRespDto;
import site.metacoding.animalprojectfrontend.web.api.dto.post.UpdateDto;

@RequiredArgsConstructor
@Controller
public class PostController {

    private final PostService postService;
    private final HttpSession session;

    // 상세검색 메서드
    public void search(Page<Post> posts, Integer page, Model model) {
        List<DetailSearchRespDto> detailSearchRespDtos = new ArrayList<DetailSearchRespDto>();

        for (Post postList : posts) {
            DetailSearchRespDto postRespDto = new DetailSearchRespDto();

            postRespDto.setId(postList.getId());
            postRespDto.setRegion(postList.getRegion());
            postRespDto.setType(postList.getType());
            postRespDto.setCategory(postList.getCategory());
            postRespDto.setTitle(postList.getTitle());
            postRespDto.setUsername(postList.getUser().getUsername());
            postRespDto.setCreateDate(postList.yyyymmdd());
            postRespDto.setView(postList.getView());
            postRespDto.setRecommended(postList.getRecommended());
            detailSearchRespDtos.add(postRespDto);
        }

        List<Integer> pageList = new ArrayList<>();
        for (int i = 0; i < posts.getTotalPages(); i++) {
            pageList.add(i);
        }

        PageRespDto pageRespDto = new PageRespDto();
        pageRespDto.setTotal(pageList);
        pageRespDto.setHasNext(posts.hasNext());
        pageRespDto.setHasPrevious(posts.hasPrevious());

        model.addAttribute("posts", detailSearchRespDtos);
        model.addAttribute("pages", pageRespDto);
        model.addAttribute("prevPage", page - 1);
        model.addAttribute("nextPage", page + 1);
    }

    // 상세검색
    @GetMapping("/blog/post/search")
    public String search(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(value = "board") String board,
            @RequestParam(value = "sort", required = false) String sort,
            @RequestParam(value = "searchBy", required = false) String searchBy,
            @RequestParam(value = "query", required = false) String query,
            @RequestParam(value = "category", required = false) String category,
            @RequestParam(value = "type", required = false) String type,
            String region, Model model, Pageable pageable) {

        PageRequest pr = PageRequest.of(page, 10, Sort.by(Direction.DESC, "id"));
        PageRequest prView = PageRequest.of(page, 10, Sort.by(Direction.DESC, "view"));
        PageRequest prRec = PageRequest.of(page, 10, Sort.by(Direction.DESC, "recommended"));

        /** 지역 or 품종 검색 폼 */
        if (region != null && type != null) {
            // 지역,품종 요청값 없을 때 redirect
            if (region.equals("all") && type.equals("all")) {
                String redirect = "redirect:/blog/" + board;
                return redirect;
            }
            // 입양후기 지역만 선택했을 때
            else if (region != "all" && type.equals("all")) {
                Page<Post> posts = postService.지역별보기(board, region, pr);
                search(posts, page, model);
                return "blog/adoptboard";
            }
            // 입양후기 종류만 선택했을 때
            else if (region.equals("all") && type != "all") {
                Page<Post> posts = postService.종류별보기(board, type, pr);
                search(posts, page, model);
                return "blog/adoptboard";
            }
            // 입양후기 지역, 종류 모두 선택했을 때
            else if (region != "all" && type != "all") {
                Page<Post> posts = postService.지역종류별보기(board, region, type, pr);
                search(posts, page, model);
                return "blog/adoptboard";
            }
        }

        /** 지역 or 분류 검색 폼 */
        if (region != null && category != null) {
            // 지역,품종 요청값 없을 때 redirect
            if (region.equals("all") && category.equals("all")) {
                String redirect = "redirect:/blog/" + board;
                return redirect;
            }
            // 입양후기 지역만 선택했을 때
            else if (region != "all" && category.equals("all")) {
                Page<Post> posts = postService.지역별보기(board, region, pr);
                search(posts, page, model);
                return "blog/regionboard";
            }
            // 입양후기 종류만 선택했을 때
            else if (region.equals("all") && category != "all") {
                Page<Post> posts = postService.분류별보기(board, category, pr);
                search(posts, page, model);
                return "blog/regionboard";
            }
            // 입양후기 지역, 종류 모두 선택했을 때
            else if (region != "all" && category != "all") {
                Page<Post> posts = postService.지역분류별보기(board, region, category, pr);
                search(posts, page, model);
                return "blog/regionboard";
            }
        }

        /** 재정렬 폼 */
        if (sort != null) {
            // 최신순
            if (sort.equals("new")) {
                String redirect = "redirect:/blog/" + board;
                return redirect;
            }
            // 조회순
            else if (sort.equals("view")) {
                Page<Post> posts = postService.글목록보기(board, prView);
                search(posts, page, model);
                return "blog/" + board + "board";
            }
            // 추천순
            else if (sort.equals("rec")) {
                Page<Post> posts = postService.글목록보기(board, prRec);
                search(posts, page, model);
                return "blog/" + board + "board";
            }
        }

        /** 제목 내용 작성자 검색 폼 */
        if (searchBy != null
                && (searchBy.equals("title") || searchBy.equals("content") || searchBy.equals("username"))) {
            Page<Post> posts = postService.게시글검색(board, query, pr, searchBy);
            search(posts, page, model);
            return "blog/" + board + "board";
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
                postRespDto.setCreateDate(postLists.yyyymmdd());
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
        List<DetailSearchRespDto> adoptPostRespDtoList = new ArrayList<DetailSearchRespDto>();

        for (Post postList : posts) {
            DetailSearchRespDto postRespDto = new DetailSearchRespDto();

            postRespDto.setId(postList.getId());
            postRespDto.setRegion(postList.getRegion());
            postRespDto.setType(postList.getType());
            postRespDto.setTitle(postList.getTitle());
            postRespDto.setUsername(postList.getUser().getUsername());
            postRespDto.setCreateDate(postList.yyyymmdd());
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

            postRespDto.setId(postList.getId());
            postRespDto.setRegion(postList.getRegion());
            postRespDto.setCategory(postList.getCategory());
            postRespDto.setTitle(postList.getTitle());
            postRespDto.setUsername(postList.getUser().getUsername());
            postRespDto.setCreateDate(postList.yyyymmdd());
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
            postRespDto.setCreateDate(postList.yyyymmdd());
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

        User principal = (User) session.getAttribute("principal");

        Post postEntity = postService.글상세보기(id);

        Integer updateView = postEntity.getView() + 1;

        PostDetailRespDto postDetailRespDto = new PostDetailRespDto();
        postDetailRespDto.setId(postEntity.getId());
        postDetailRespDto.setBoard(postEntity.getBoard());
        postDetailRespDto.setTitle(postEntity.getTitle());
        postDetailRespDto.setContent(postEntity.getContent());
        postDetailRespDto.setCreateDate(postEntity.yyyymmddhhmm());
        postDetailRespDto.setUser(postEntity.getUser());
        postDetailRespDto.setView(updateView);
        postDetailRespDto.setRecommended(postEntity.getRecommended());

        postService.조회수증가(updateView, id);

        List<CommentRespDto> comments = new ArrayList<>();
        for (Comment comment : postEntity.getComments()) {
            CommentRespDto dto = new CommentRespDto();
            dto.setContent(comment);
            if (principal != null) {
                if (comment.getUser().getId().equals(principal.getId())) {
                    dto.setAuth(true);
                } else {
                    dto.setAuth(false);
                }
            } else {
                dto.setAuth(false);
            }
            comments.add(dto);
        }

        if (principal != null) {
            if (principal.getId() == postEntity.getUser().getId()) {
                model.addAttribute("principals", true);
            } else {
                model.addAttribute("principals", false);
            }
        }
        if (comments.size() != 0) {
            model.addAttribute("comments", comments);
        }
        model.addAttribute("posts", postDetailRespDto);

        // model.addAttribute("principal", principal.getId());

        return "/blog/post/postDetail";
    }

    // 글쓰기
    @GetMapping("/s/blog/writeForm")
    public String writeForm() {
        return "/blog/writeForm";
    }

    // 글 수정하기
    @GetMapping("/s/post/updateForm/{id}")
    public String updateForm(@PathVariable Integer id, Model model) {
        Post post = postService.글상세보기(id);
        UpdateDto updateDto = new UpdateDto();
        updateDto.setId(post.getId());
        updateDto.setTitle(post.getTitle());
        updateDto.setContent(post.getContent());
        updateDto.setBoard(post.getBoard());
        model.addAttribute("post", updateDto);
        return "/blog/updateForm";
    }

}
