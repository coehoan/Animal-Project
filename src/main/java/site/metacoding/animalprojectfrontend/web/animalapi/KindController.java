package site.metacoding.animalprojectfrontend.web.animalapi;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.animalprojectfrontend.animalkind.kindservice.KindService;
import site.metacoding.animalprojectfrontend.animalkind.modeling.Kind;
import site.metacoding.animalprojectfrontend.animalkind.modeling.KindDto;

@RequiredArgsConstructor
@Controller
public class KindController {
    private final KindService kindService;

    @GetMapping("/kind")
    public String download(KindDto kindDto, Model model) {
        List<Kind> kindEntity = kindService.다운로드(kindDto);

        model.addAttribute("kindlist", kindEntity);

        return "/api/kindDownload";
    }
}
