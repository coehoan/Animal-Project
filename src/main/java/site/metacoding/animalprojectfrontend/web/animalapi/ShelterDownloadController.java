package site.metacoding.animalprojectfrontend.web.animalapi;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.animalprojectfrontend.domain.shelter.Shelter;
import site.metacoding.animalprojectfrontend.service.api.ShelterService;

@RequiredArgsConstructor
@Controller
public class ShelterDownloadController {

    private final ShelterService shelterService;

    @GetMapping("/shelter")
    public String download(Shelter shelter, Model model) {

        List<Shelter> shelterEntity = shelterService.다운로드(shelter);

        model.addAttribute("shelterlist", shelterEntity);
        return "/api/shelterDownload";
    }
}
