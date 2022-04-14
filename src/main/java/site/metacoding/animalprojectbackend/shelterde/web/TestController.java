package site.metacoding.animalprojectbackend.shelterde.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.animalprojectbackend.shelterde.service.ShelterDeService;
import site.metacoding.animalprojectbackend.shelterde.shelterdedto.ShelterDeDto;

@RequiredArgsConstructor
@Controller
public class TestController {

    private final ShelterDeService Service;

    @GetMapping("/shelter/detail")
    public String testDownload(ShelterDeDto shelterDto, Model model) {

        List<ShelterDeDto> shelterEntity = Service.다운로드(shelterDto);

        model.addAttribute("shelterlist", shelterEntity);

        return "/api/shelterDeDownload";

    }
}
