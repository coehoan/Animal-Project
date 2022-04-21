package site.metacoding.animalprojectfrontend.web.api;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.animalprojectfrontend.domain.animals.Animals;
import site.metacoding.animalprojectfrontend.service.api.AnimalsService;
import site.metacoding.animalprojectfrontend.web.api.dto.animals.PostRegionDto;
import site.metacoding.animalprojectfrontend.web.api.dto.animals.ResponseDto;

@RequiredArgsConstructor
@RestController
public class AnimalApiController {

    private final AnimalsService animalsService;

    @CrossOrigin
    @GetMapping("/search/animals/region")
    public ResponseDto<?> getRegion(
            @RequestParam(name = "firstdate", defaultValue = "0", required = false) String firstDate,
            @RequestParam(name = "lastdate", defaultValue = "0", required = false) String lastDate,
            @RequestParam(name = "kind", defaultValue = "0", required = false) String kind,
            @RequestParam(name = "kind-of", defaultValue = "0", required = false) String kindOf,
            @RequestParam(name = "keyword", required = false) String keyword,
            @RequestParam(name = "sido", required = true) String keywordOfSido,
            @RequestParam(name = "sigungu", required = true) String keywordOfSigungu, Model model) {
        System.out.println("타나?");
        System.out
                .println("받은 쿼리스트링 ====" + keywordOfSido + keywordOfSigungu);

        if (keywordOfSido != null) {
            List<Animals> animalsEntity = animalsService.지역검색(keywordOfSido, keywordOfSigungu);

            System.out.println("엔티티 컨트롤러에서 받았나?" + animalsEntity);

            return new ResponseDto<>(1, "검색 성공", animalsEntity);
        } else {
            return new ResponseDto<>(-1, "검색 실패", null);
        }

    }
}
