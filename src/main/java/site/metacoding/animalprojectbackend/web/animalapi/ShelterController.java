package site.metacoding.animalprojectbackend.web.animalapi;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.animalprojectbackend.domain.shelter.ShelterDto;
import site.metacoding.animalprojectbackend.service.api.ShelterService;

@RequiredArgsConstructor
@Controller
public class ShelterController {
    
    private final ShelterService shelterService;

    @GetMapping("/shelter/test")
    public String download(ShelterDto shelterDto, Model model) {

        List<ShelterDto> shelterEntity = shelterService.다운로드(shelterDto);

        model.addAttribute("shelterlist", shelterEntity);
        return "/api/shelterDownload";
    }
}
