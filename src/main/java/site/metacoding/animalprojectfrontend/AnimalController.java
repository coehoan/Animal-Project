package site.metacoding.animalprojectfrontend;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.animalprojectfrontend.domain.post.Post;
import site.metacoding.animalprojectfrontend.service.PostService;

@RequiredArgsConstructor
@Controller
public class AnimalController {
    private final PostService postService;

    @GetMapping("/")
    public String main(Model model) {
        List<Post> posts = postService.메인글목록();
        model.addAttribute("posts", posts);
        return "/main/mainForm";
    }

    // @GetMapping("/main/joinForm")
    // public String join() {
    // return "/main/joinForm";
    // }

    // @GetMapping("/main/loginForm")
    // public String login() {
    // return "/main/loginForm";
    // }

    @GetMapping("/animal")
    public String animal() {
       
        return "/animal/animalList";
    }

    // @GetMapping("/animal/shelterList")
    // public String shelterList() {
    // return "/animal/shelterList";
    // }

    @GetMapping("/withus/doctor")
    public String withDoctor() {
        return "/withus/doctor";
    }

    @GetMapping("/withus/kara")
    public String kara() {
        return "/withus/kara";
    }
    // ===================Post====================/
}
