package site.metacoding.animalprojectbackend.service.api;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import site.metacoding.animalprojectbackend.domain.sido.SidoDto;
import site.metacoding.animalprojectbackend.domain.sido.SidoRepository;
import site.metacoding.animalprojectbackend.domain.sigungu.ResponseDto;
import site.metacoding.animalprojectbackend.domain.sigungu.SigunguDto;
import site.metacoding.animalprojectbackend.domain.sigungu.SigunguRepository;

@RequiredArgsConstructor
@Service
public class TestService {

    private final SidoRepository sidoRepository;
    private final SigunguRepository sigunguRepository;

    @Transactional
    public List<SigunguDto> 테스트(SigunguDto sigunguDto) {

        List<SigunguDto> lists = new ArrayList<>();
        List<SidoDto> sidoEntity = sidoRepository.findAll(); // 시도 모두 찾기
        List<SidoDto> sidoRepo = sidoRepository.findCd(); // 시도 코드만 찾기
        Set<SidoDto> sidoHash = sidoRepository.findCdHash();

        // 서비스키
        String key = "jDqHGG%2BaNG47ijh6s3XzB%2BuF8fJOeovccnw%2FZtc9wLQUaKJumPo%2Frl1a2ygZ68dv9L0PD7drvpjPAeTnnB9f%2FQ%3D%3D";

        // 시도 코드에 따른 변수들
        String gwangju = "6290000";
        String busan = "6260000";

        StringBuffer urisb = new StringBuffer();
        RestTemplate restTemplate = new RestTemplate();
        ResponseDto response = new ResponseDto();


        for (int i = 0; i < sidoRepo.size(); i++) { // 시도 사이즈만큼 반복

            try {
                URI uri = new URI(urisb.toString());

                for(int p = 0; p < sidoRepo.size(); p++) {
                    urisb.append("http://apis.data.go.kr/1543061/abandonmentPublicSrvc/sigungu?");
                    urisb.append("serviceKey=" + key);
                    urisb.append("&upr_cd=");
                    urisb.append(sidoRepo.get(i).getOrgCd());
                    urisb.append("&_type=JSON");

                    System.out.println(urisb.toString());
                    response = restTemplate.getForObject(uri, ResponseDto.class);
                }
                

                System.out.println(response);

                List<ResponseDto> sigunguList = new ArrayList<>();

                for (int p = 0; p < response.getResponse().getBody().getItems().getItem().size(); p++) {
                    sigunguList.add(response);

                }

                System.out.println(sigunguList);

                for (int o = 0; o < sigunguList.size(); o++) {
                    SigunguDto result = new SigunguDto(o,
                            sigunguList.get(o).getResponse().getBody().getItems().getItem().get(o).getOrgCd(),
                            sigunguList.get(o).getResponse().getBody().getItems().getItem().get(o).getOrgdownNm(),
                            sigunguList.get(o).getResponse().getBody().getItems().getItem().get(o).getUprCd());

                    lists.add(result);
                }

                System.out.println(lists);

                List<SigunguDto> sigunguEntity = sigunguRepository.saveAll(lists);

                return sigunguEntity;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
