package site.metacoding.animalprojectfrontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AnimalController {

    @GetMapping("/")
    public String main() {
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

    @GetMapping("/animal/animalList")
    public String animal() {
        return "/animal/animalList";
    }

    @GetMapping("/animal/shelterList")
    public String shelterList() {
        return "/animal/shelterList";
    }

    @GetMapping("/blog")
    public String blog() {
        return "/blog/blogMain";
    }

    @GetMapping("/blog/writeForm")
    public String writeForm() {
        return "/blog/writeForm";
    }

    @GetMapping("/blog/adoptboard/post/1")
    public String adoptboardPost() {
        return "/blog/post/adoptPost";
    }

    @GetMapping("/blog/regionboard/post/1")
    public String regionboardPost() {
        return "/blog/post/regionPost";
    }

    @GetMapping("/blog/freeboard/post/1")
    public String freeboardPost() {
        return "/blog/post/freePost";
    }

    @GetMapping("/withus/doctor")
    public String withDoctor() {
        return "/withus/doctor";
    }

    @GetMapping("/withus/kara")
    public String kara() {
        return "/withus/kara";
    }
    // ===================Post====================//
}
