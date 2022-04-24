package site.metacoding.animalprojectfrontend.web.animalapi;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.animalprojectfrontend.domain.sido.Sido;
import site.metacoding.animalprojectfrontend.service.api.SidoService;

@RequiredArgsConstructor
@Controller
public class SidoController {

    private final SidoService sidoService;

    @GetMapping("/sido")

    public String download(Sido sido, Model model) {

        List<Sido> sidoEntity = sidoService.다운로드(sido);

        model.addAttribute("sidolist", sidoEntity);

        return "/api/sidoDownload";

    }
}
