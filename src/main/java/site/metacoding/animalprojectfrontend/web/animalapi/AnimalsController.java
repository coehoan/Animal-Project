package site.metacoding.animalprojectfrontend.web.animalapi;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.animalprojectfrontend.domain.animals.Animals;
import site.metacoding.animalprojectfrontend.service.api.AnimalsService;

@RequiredArgsConstructor
@Controller
public class AnimalsController {

    private final AnimalsService animalsService;

    @GetMapping("/animals")
    public String download(Animals animals, Model model) {

        List<Animals> animailEntity = animalsService.다운로드();

        model.addAttribute("animalslist", animailEntity);
        return "/api/animalsDownload";
    }

}
