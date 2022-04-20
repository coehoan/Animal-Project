package site.metacoding.animalprojectfrontend;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import site.metacoding.animalprojectfrontend.domain.animals.Animals;
import site.metacoding.animalprojectfrontend.service.api.AnimalsService;
import site.metacoding.animalprojectfrontend.web.api.dto.animals.PostRegionDto;
import site.metacoding.animalprojectfrontend.web.api.dto.animals.ResponseDto;

@RequiredArgsConstructor
@Controller
public class AnimalController {

    private final AnimalsService animalsService;

    @GetMapping("/")
    public String main() {
        return "/main/mainForm";
    }

    // @GetMapping("/main/joinForm")
    // public String join() {
    // return "/main/joinForm";
    // }

    // @GetMapping("/main/loginForm")
    // public String login() {
    // return "/main/loginForm";
    // }

    @GetMapping("/animal/animalList")
    public String animal() {
        return "/animal/animalList";
    }

    @GetMapping("/animal/shelterList")
    public String shelterList() {
        return "/animal/shelterList";
    }

    @GetMapping("/blog")
    public String blog() {
        return "blog/blogMain";
    }

    @GetMapping("/blog/writeForm")
    public String writeForm() {
        return "/blog/writeForm";
    }

    @CrossOrigin
    @PostMapping("/search/animals/region")
    public @ResponseBody ResponseDto<?> getRegion(@RequestBody PostRegionDto keywordOfRegion, Model model) {
        System.out.println("타나?");
        System.out.println("받은 쿼리스트링 ====" + keywordOfRegion.getSido() + keywordOfRegion.getSigungu() + keywordOfRegion);
        
        if(animalsService.지역검색(keywordOfRegion.getSido(), keywordOfRegion.getSigungu()) != null) {
            List<Animals> animalsEntity = animalsService.지역검색(keywordOfRegion.getSido(), keywordOfRegion.getSigungu());
            model.addAttribute("regionlist", animalsEntity);
            
            return new ResponseDto<>(1, "검색 성공", animalsEntity);
        } else {
            return new ResponseDto<>(1, "검색 실패", null);
        }
    }

    @CrossOrigin
    @GetMapping("/animals/region/{sido}/{sigungu}")
    public String regionList(@PathVariable(name = "sido") String sido, @PathVariable(name = "sigungu") String sigungu, Model model) {
        
        return "/animal/animalList";
    }

    @GetMapping("/download")
    public String download(Animals animals, Model model) {

        List<Animals> animailEntity = animalsService.다운로드(animals);
        model.addAttribute("animalslist", animailEntity);

        return "/animal/animalsDownload";
    }

    @GetMapping("/blog/adoptboard/post/1")
    public String adoptboardPost() {
        return "/blog/post/adoptPost";
    }

    @GetMapping("/blog/regionboard/post/1")
    public String regionboardPost() {
        return "/blog/post/regionPost";
    }

    @GetMapping("/blog/freeboard/post/1")
    public String freeboardPost() {
        return "/blog/post/freePost";
    }

    @GetMapping("/withus/doctor")
    public String withDoctor() {
        return "/withus/doctor";
    }

    @GetMapping("/withus/kara")
    public String kara() {
        return "/withus/kara";
    }
    // ===================Post====================//

}
