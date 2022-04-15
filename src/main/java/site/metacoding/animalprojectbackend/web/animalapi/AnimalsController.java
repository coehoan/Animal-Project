package site.metacoding.animalprojectbackend.web.animalapi;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.animalprojectbackend.domain.animals.Animals;
import site.metacoding.animalprojectbackend.service.api.AnimalsService;

@RequiredArgsConstructor
@Controller
public class AnimalsController {

    private final AnimalsService animalsService;

    @GetMapping("/animals")
    public String download(Animals animals, Model model) {

        List<Animals> animailEntity = animalsService.다운로드(animals);

        model.addAttribute("animalslist", animailEntity);
        return "/api/animalsDownload";
    }
    
}
