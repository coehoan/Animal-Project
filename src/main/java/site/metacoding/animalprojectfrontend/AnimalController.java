package site.metacoding.animalprojectfrontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AnimalController {

    @GetMapping("/")
    public String main() {
        return "/main/mainForm";
    }
}
