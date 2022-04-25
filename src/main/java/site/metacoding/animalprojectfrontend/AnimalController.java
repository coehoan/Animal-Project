package site.metacoding.animalprojectfrontend;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.animalprojectfrontend.domain.user.User;
import site.metacoding.animalprojectfrontend.service.UserService;
import site.metacoding.animalprojectfrontend.web.api.dto.user.JoinDto;

@RequiredArgsConstructor
@Controller
public class AnimalController {

    private final UserService userService;
    private final HttpSession httpSession;

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
