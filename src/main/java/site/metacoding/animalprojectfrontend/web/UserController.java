package site.metacoding.animalprojectfrontend.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.animalprojectfrontend.service.UserService;

@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;
    private final HttpSession session;

    @GetMapping("/logout")
    public String logout() {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/main/joinForm")
    public String join() {
        return "/main/joinForm";
    }

    @GetMapping("/main/loginForm")
    public String login() {
        return "/main/loginForm";
    }

    // 보호소 정보
    @GetMapping("/animal/shelterList")
    public String shelterList() {
        return "/animal/shelterList";
    }
    // 보호소 정보 끝
}
