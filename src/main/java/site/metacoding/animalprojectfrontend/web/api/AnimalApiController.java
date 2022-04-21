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

    // 해당되는 쿼리스트링만 required true 해주기
    @CrossOrigin
    @GetMapping("/search/animals/all")
    public ResponseDto<?> getAll(
            @RequestParam(name = "firstdate", required = true) String keywordOfirstDate,
            @RequestParam(name = "lastdate", required = true) String keywordOflastDate,
            @RequestParam(name = "kind", required = true) String keywordOfkind,
            @RequestParam(name = "kindOf", required = true) String keywordOfkindOf,
            @RequestParam(name = "keyword", required = false) String keyword,
            @RequestParam(name = "sido", required = true) String keywordOfSido,
            @RequestParam(name = "sigungu", required = true) String keywordOfSigungu, Model model) {
        System.out.println("타나?");
        System.out
                .println("받은 쿼리스트링 ====" + keywordOfSido + keywordOfSigungu + keywordOfirstDate + keywordOflastDate + keywordOfkind + keywordOfkindOf);

        if (keywordOfSido != null) { // 쿼리스트링이 null이 아니면
            List<Animals> getAllEntity = animalsService.전체검색(keywordOfSido, keywordOfSigungu, keywordOfkind, keywordOfkindOf, keywordOfirstDate, keywordOflastDate);

            System.out.println("엔티티 컨트롤러에서 받았나?" + getAllEntity);

            return new ResponseDto<>(1, "검색 성공", getAllEntity);
        } else {
            return new ResponseDto<>(-1, "검색 실패", null);
        }

    }

    @CrossOrigin
    @GetMapping("/search/animals/region")
    public ResponseDto<?> getRegion(
            @RequestParam(name = "firstdate", required = false) String keywordOfirstDate,
            @RequestParam(name = "lastdate", required = false) String keywordOflastDate,
            @RequestParam(name = "kind", required = false) String keywordOfkind,
            @RequestParam(name = "kindOf", required = false) String keywordOfkindOf,
            @RequestParam(name = "keyword", required = false) String keyword,
            @RequestParam(name = "sido", required = true) String keywordOfSido,
            @RequestParam(name = "sigungu", required = true) String keywordOfSigungu, Model model) {
        System.out.println("타나?");
        System.out
                .println("받은 쿼리스트링 ====" + keywordOfSido + keywordOfSigungu);

        if (keywordOfSido != null) { // 쿼리스트링이 null이 아니면
            List<Animals> getRegionEntity = animalsService.지역검색(keywordOfSido, keywordOfSigungu);

            System.out.println("엔티티 컨트롤러에서 받았나?" + getRegionEntity);

            return new ResponseDto<>(1, "검색 성공", getRegionEntity);
        } else {
            return new ResponseDto<>(-1, "검색 실패", null);
        }

    }

    @CrossOrigin
    @GetMapping("/search/animals/region-sido")
    public ResponseDto<?> getRegionSido(
            @RequestParam(name = "firstdate", required = false) String keywordOfirstDate,
            @RequestParam(name = "lastdate", required = false) String keywordOflastDate,
            @RequestParam(name = "kind", required = false) String keywordOfkind,
            @RequestParam(name = "kindOf", required = false) String keywordOfkindOf,
            @RequestParam(name = "keyword", defaultValue = "0", required = false) String keyword,
            @RequestParam(name = "sido", required = true) String keywordOfSido,
            @RequestParam(name = "sigungu", required = false) String keywordOfSigungu, Model model) {
        System.out.println("타나?");
        System.out
                .println("받은 쿼리스트링 ====" + keywordOfSido);

        if (keywordOfSido != null) { // 쿼리스트링이 null이 아니면
            List<Animals> getRegionEntity = animalsService.지역검색시도(keywordOfSido);

            System.out.println("엔티티 컨트롤러에서 받았나?" + getRegionEntity);

            return new ResponseDto<>(1, "검색 성공", getRegionEntity);
        } else {
            return new ResponseDto<>(-1, "검색 실패", null);
        }

    }

    @CrossOrigin
    @GetMapping("/search/animals/day")
    public ResponseDto<?> getDay(
            @RequestParam(name = "firstdate", required = true) String keywordOfirstDate,
            @RequestParam(name = "lastdate", required = true) String keywordOflastDate,
            @RequestParam(name = "kind", required = false) String keywordOfkind,
            @RequestParam(name = "kindOf", required = false) String keywordOfkindOf,
            @RequestParam(name = "keyword", required = false) String keyword,
            @RequestParam(name = "sido", required = false) String keywordOfSido,
            @RequestParam(name = "sigungu", required = false) String keywordOfSigungu, Model model) {

        System.out.println("타나?");
        System.out
                .println("받은 쿼리스트링 ====" + keywordOfirstDate + keywordOflastDate);

        String[] firstDate = keywordOfirstDate.split("-"); // 날짜가 정말 아주 못되게 찍혀서 -로 나누어줌
        System.out.println(firstDate);
        StringBuilder fDsb = new StringBuilder();

        fDsb.append(firstDate[0]);
        fDsb.append(firstDate[1]);
        fDsb.append(firstDate[2]);

        String[] lastDate = keywordOflastDate.split("-");
        StringBuilder lDsb = new StringBuilder();
        lDsb.append(lastDate[0]);
        lDsb.append(lastDate[1]);
        lDsb.append(lastDate[2]);

        if (keywordOfirstDate != null) {
            List<Animals> getDayEntity = animalsService.날짜검색(fDsb.toString(), lDsb.toString());

            System.out.println("엔티티 컨트롤러에서 받았나?" + getDayEntity);

            return new ResponseDto<>(1, "검색 성공", getDayEntity);
        } else {
            return new ResponseDto<>(-1, "검색 실패", null);
        }

    }

    @CrossOrigin
    @GetMapping("/search/animals/kind")
    public ResponseDto<?> getKind(
            @RequestParam(name = "firstdate", required = false) String keywordOfirstDate,
            @RequestParam(name = "lastdate", required = false) String keywordOflastDate,
            @RequestParam(name = "kind", required = true) String keywordOfkind,
            @RequestParam(name = "kindOf", required = true) String keywordOfkindOf,
            @RequestParam(name = "keyword", required = false) String keyword,
            @RequestParam(name = "sido", required = false) String keywordOfSido,
            @RequestParam(name = "sigungu", required = false) String keywordOfSigungu, Model model) {
        System.out.println("타나?");
        System.out
                .println("받은 쿼리스트링 ====" + keywordOfkind + keywordOfkindOf);

        if (keywordOfkind != null) { // 쿼리스트링이 null이 아니면
            List<Animals> getKindEntity = animalsService.품종검색(keywordOfkind, keywordOfkindOf);

            System.out.println("엔티티 컨트롤러에서 받았나?" + getKindEntity);

            return new ResponseDto<>(1, "검색 성공", getKindEntity);
        } else {
            return new ResponseDto<>(-1, "검색 실패", null);
        }

    }

    @CrossOrigin
    @GetMapping("/search/animals/kind-only")
    public ResponseDto<?> getKindOnly(
            @RequestParam(name = "firstdate", required = false) String keywordOfirstDate,
            @RequestParam(name = "lastdate", required = false) String keywordOflastDate,
            @RequestParam(name = "kind", required = true) String keywordOfkind,
            @RequestParam(name = "kindOf", required = false) String keywordOfkindOf,
            @RequestParam(name = "keyword", required = false) String keyword,
            @RequestParam(name = "sido", required = false) String keywordOfSido,
            @RequestParam(name = "sigungu", required = false) String keywordOfSigungu, Model model) {
        System.out.println("타나?");
        System.out
                .println("받은 쿼리스트링 ====" + keywordOfkind);

        if (keywordOfkind != null) { // 쿼리스트링이 null이 아니면
            List<Animals> getKindEntity = animalsService.품종검색품종만(keywordOfkind);

            System.out.println("엔티티 컨트롤러에서 받았나?" + getKindEntity);

            return new ResponseDto<>(1, "검색 성공", getKindEntity);
        } else {
            return new ResponseDto<>(-1, "검색 실패", null);
        }

    }
}
