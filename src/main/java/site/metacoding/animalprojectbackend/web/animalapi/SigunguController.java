package site.metacoding.animalprojectbackend.web.animalapi;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.animalprojectbackend.domain.sigungu.SigunguDto;
import site.metacoding.animalprojectbackend.service.api.SigunguService;
import site.metacoding.animalprojectbackend.service.api.TestService;

@RequiredArgsConstructor
@Controller
public class SigunguController {

    private final SigunguService sigunguService;
    private final TestService testService;
    
    @GetMapping("/sigungu/busan")
    public String download(SigunguDto sigunguDto, Model model) {

        List<SigunguDto> sigunguEntity = sigunguService.부산다운로드(sigunguDto);

        model.addAttribute("busanlist", sigunguEntity);

        return "/api/sigunguDownload";
    }

    @GetMapping("/sigungu/deagu")
    public String deagu(SigunguDto sigunguDto, Model model) {
        
        List<SigunguDto> sigunguEntity = sigunguService.대구다운로드(sigunguDto);

        model.addAttribute("deagulist", sigunguEntity);

        return "/api/sigunguDownload";
    }

    @GetMapping("/sigungu/incheon")
    public String incheon(SigunguDto sigunguDto, Model model) {
        
        List<SigunguDto> sigunguEntity = sigunguService.인천다운로드(sigunguDto);

        model.addAttribute("incheonlist", sigunguEntity);

        return "/api/sigunguDownload";
    }

    @GetMapping("/sigungu/gwangju")
    public String gwangju(SigunguDto sigunguDto, Model model) {

        List<SigunguDto> sigunguEntity = sigunguService.광주다운로드(sigunguDto);

        model.addAttribute("gwangjulist", sigunguEntity);

        return "/api/sigunguDownload";
    }

    @GetMapping("/sigungu/seajong")
    public String seajong(SigunguDto sigunguDto, Model model) {

        List<SigunguDto> sigunguEntity = sigunguService.세종다운로드(sigunguDto);

        model.addAttribute("seajonglist", sigunguEntity);

        return "/api/sigunguDownload";
    }

    @GetMapping("/sigungu/jeonla")
    public String jeonla(SigunguDto sigunguDto, Model model) {

        List<SigunguDto> sigunguEntity = sigunguService.전라남도다운로드(sigunguDto);

        model.addAttribute("jeonlalist", sigunguEntity);

        return "/api/sigunguDownload";
    }

    @GetMapping("/sigungu/jeonbook")
    public String jeonbook(SigunguDto sigunguDto, Model model) {

        List<SigunguDto> sigunguEntity = sigunguService.전라북도다운로드(sigunguDto);

        model.addAttribute("jeonbooklist", sigunguEntity);

        return "/api/sigunguDownload";
    }

    @GetMapping("/sigungu/jeju")
    public String jeju(SigunguDto sigunguDto, Model model) {

        List<SigunguDto> sigunguEntity = sigunguService.제주다운로드(sigunguDto);

        model.addAttribute("jejulist", sigunguEntity);

        return "/api/sigunguDownload";
    }

    @GetMapping("/sigungu/gangweon")
    public String gangweon(SigunguDto sigunguDto, Model model) {

        List<SigunguDto> sigunguEntity = sigunguService.강원도다운로드(sigunguDto);

        model.addAttribute("gangweonlist", sigunguEntity);

        return "/api/sigunguDownload";
    }

    @GetMapping("/sigungu/gyeongi")
    public String gyeongi(SigunguDto sigunguDto, Model model) {

        List<SigunguDto> sigunguEntity = sigunguService.경기도다운로드(sigunguDto);

        model.addAttribute("gyeongilist", sigunguEntity);

        return "/api/sigunguDownload";
    }

    @GetMapping("/sigungu/gyeongsang")
    public String gyeongsang(SigunguDto sigunguDto, Model model) {

        List<SigunguDto> sigunguEntity = sigunguService.경상남도다운로드(sigunguDto);

        model.addAttribute("gyeongsanglist", sigunguEntity);

        return "/api/sigunguDownload";
    }

    @GetMapping("/sigungu/ulsan")
    public String ulsan(SigunguDto sigunguDto, Model model) {

        List<SigunguDto> sigunguEntity = sigunguService.울산다운로드(sigunguDto);

        model.addAttribute("ulsanlist", sigunguEntity);

        return "/api/sigunguDownload";
    }

    @GetMapping("/sigungu/choongnam")
    public String choongnam(SigunguDto sigunguDto, Model model) {

        List<SigunguDto> sigunguEntity = sigunguService.충청남도다운로드(sigunguDto);

        model.addAttribute("choongnamlist", sigunguEntity);

        return "/api/sigunguDownload";
    }

    @GetMapping("/sigungu/choongbook")
    public String choongbook(SigunguDto sigunguDto, Model model) {

        List<SigunguDto> sigunguEntity = sigunguService.충청북도다운로드(sigunguDto);

        model.addAttribute("choongbooklist", sigunguEntity);

        return "/api/sigunguDownload";
    }

    @GetMapping("/sigungu/test")
    public String test(SigunguDto sigunguDto, Model model) {

        List<SigunguDto> sigunguEntity = testService.테스트(sigunguDto);

        model.addAttribute("testlist", sigunguEntity);

        return "/api/test";
    }
    
}
