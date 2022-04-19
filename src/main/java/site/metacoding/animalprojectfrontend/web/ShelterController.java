package site.metacoding.animalprojectfrontend.web;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import site.metacoding.animalprojectfrontend.domain.user.shelterde.ShelterDe;
import site.metacoding.animalprojectfrontend.service.ShelterDeService;

@RequiredArgsConstructor
@Controller
public class ShelterController {
    private final ShelterDeService shelterDeService;

    @GetMapping("/shelter/init-data")
    public @ResponseBody List<ShelterDe> initData(ShelterDe shelterDto, Model model) {

        List<ShelterDe> sheltersEntity = shelterDeService.다운로드(shelterDto);

        return sheltersEntity;

    }

    @GetMapping("/animal/shelterList")
    public String list(Model model) {
        PageRequest pr = PageRequest.of(0, 1000);
        Page<ShelterDe> sheltersEntity = shelterDeService.전체보기(pr);

        model.addAttribute("shelterlistPage", sheltersEntity);

        return "/animal/shelterList";
    }

    @GetMapping("/test/shelter")
    public @ResponseBody Page<ShelterDe> list() {
        PageRequest pr = PageRequest.of(1, 3);
        Page<ShelterDe> sheltersEntity = shelterDeService.전체보기(pr);

        return sheltersEntity;
    }
}
