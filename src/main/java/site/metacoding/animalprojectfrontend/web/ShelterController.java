package site.metacoding.animalprojectfrontend.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import site.metacoding.animalprojectfrontend.domain.shelterde.ShelterDe;
import site.metacoding.animalprojectfrontend.service.ShelterDeService;
import site.metacoding.animalprojectfrontend.web.api.dto.post.PageRespDto;
import site.metacoding.animalprojectfrontend.web.api.dto.shelterde.ShelterRespDto;

@RequiredArgsConstructor
@Controller
public class ShelterController {
    private final ShelterDeService shelterDeService;

    // 검색 공통 메서드
    public void search(List<ShelterDe> shelterEntity, Model model) {
        String REGEX = "[0-9]+";
        List<ShelterRespDto> shelterList = new ArrayList<>();

        for (ShelterDe shelterDe : shelterEntity) {
            ShelterRespDto shelterRespDto = new ShelterRespDto();
            shelterRespDto.setId(shelterDe.getId());
            shelterRespDto.setOrgNm(shelterDe.getOrgNm());
            shelterRespDto.setCareNm(shelterDe.getCareNm());
            shelterRespDto.setCareAddr(shelterDe.getCareAddr());
            shelterRespDto.setWeekOprStime(shelterDe.getWeekOprStime());
            shelterRespDto.setWeekOprEtime(shelterDe.getWeekOprEtime());
            shelterRespDto.setCloseDay(shelterDe.getCloseDay());
            shelterRespDto.setCareTel(shelterDe.getCareTel());
            shelterRespDto.setSaveTrgtAnimal(shelterDe.getSaveTrgtAnimal());
            if (shelterDe.getCloseDay() == null) {
                shelterRespDto.setCloseDay("정보없음");
            } else if (shelterDe.getCloseDay().matches(REGEX)) {
                shelterRespDto.setCloseDay("정보없음");
            }
            shelterList.add(shelterRespDto);
        }
        model.addAttribute("shelterlistPage", shelterList);
    }

    @GetMapping("/shelter/init-data")
    public @ResponseBody List<ShelterDe> initData(ShelterDe shelterDto, Model model) {

        List<ShelterDe> sheltersEntity = shelterDeService.다운로드(shelterDto);

        return sheltersEntity;

    }

    @GetMapping("/animal/shelterList")
    public String list(@RequestParam(defaultValue = "0", required = false) Integer page, Model model) {
        PageRequest pr = PageRequest.of(page, 10, Sort.by("id"));
        Page<ShelterDe> sheltersEntity = shelterDeService.전체보기(pr);

        List<Integer> pageList = new ArrayList<>();
        for (Integer i = 1; i <= sheltersEntity.getTotalPages(); i++) {
            pageList.add(i);
        }

        PageRespDto pageRespDto = new PageRespDto();
        pageRespDto.setTotal(pageList);
        pageRespDto.setHasNext(sheltersEntity.hasNext());
        pageRespDto.setHasPrevious(sheltersEntity.hasPrevious());

        model.addAttribute("pages", pageRespDto);
        model.addAttribute("shelterlistPage", sheltersEntity);
        model.addAttribute("prevPage", page - 1);
        model.addAttribute("nextPage", page + 1);

        return "/animal/shelterList";
    }

    @GetMapping("/animal/shelterList/search")
    public String search(
            @RequestParam(value = "sido", required = false) String sido,
            @RequestParam(value = "sigungu") String sigungu,
            @RequestParam(value = "kind", required = false) String kind,
            @RequestParam(value = "keyword", required = false) String keyword,
            Model model) {

        if (sido.equals("all") && sigungu.equals("all") && kind.equals("all")) {
            return "redirect:/animal/shelterList";
        }

        // 지역, 시군구만 선택했을 때
        if (sido != "all" && sigungu != "all" && kind.equals("all")) {
            String addr = sido + " " + sigungu;
            List<ShelterDe> shelterEntity = shelterDeService.지역별보기(addr);
            search(shelterEntity, model);
        }

        // 종류만 선택했을 때
        if (sido.equals("all") && sigungu.equals("all") && !kind.equals("all")) {
            List<ShelterDe> shelterEntity = shelterDeService.종류별보기(kind);
            search(shelterEntity, model);
        }

        // 지역, 시군구, 종류 모두 선택했을 때
        if (!sido.equals("all") && !sigungu.equals("all") && !kind.equals("all")) {
            String addr = sido + " " + sigungu;
            List<ShelterDe> shelterEntity = shelterDeService.지역종류별보기(addr, kind);
            search(shelterEntity, model);
        }

        return "/animal/shelterList";
    }
}