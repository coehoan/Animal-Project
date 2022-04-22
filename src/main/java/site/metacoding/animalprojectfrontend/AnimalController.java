package site.metacoding.animalprojectfrontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.animalprojectfrontend.service.api.AnimalsService;

@RequiredArgsConstructor
@Controller
public class AnimalController {

    private final AnimalsService animalsService;

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
