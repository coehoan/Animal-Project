package site.metacoding.animalprojectbackend.web.animalapi;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.animalprojectbackend.domain.sido.SidoDto;
import site.metacoding.animalprojectbackend.service.api.SidoService;

@RequiredArgsConstructor
@Controller
public class SidoController {
    
    private final SidoService sidoService;

    @GetMapping("/sido")
    public String download(SidoDto sidoDto, Model model) {

        List<SidoDto> sidoEntity = sidoService.다운로드(sidoDto);

        model.addAttribute("sidolist", sidoEntity);

        return "/api/sidoDownload";

    }
}
