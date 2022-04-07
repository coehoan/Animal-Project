package site.metacoding.animalprojectbackend.web.animalapi;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.animalprojectbackend.animalkind.kindservice.KindService;
import site.metacoding.animalprojectbackend.animalkind.modeling.KindDto;

@RequiredArgsConstructor
@Controller
public class KindController {
    private final KindService kindService;

    @GetMapping("/kind")
    public String download(KindDto kindDto, Model model) {
        List<KindDto> kindEntity = kindService.다운로드(kindDto);

        model.addAttribute("kindlist", kindEntity);

        return "/api/kindDownload";
    }
}
