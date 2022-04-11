package site.metacoding.animalprojectbackend.service.api;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import site.metacoding.animalprojectbackend.domain.shelter.ResponseDto;
import site.metacoding.animalprojectbackend.domain.shelter.ShelterDto;
import site.metacoding.animalprojectbackend.domain.shelter.ShelterRepository;
import site.metacoding.animalprojectbackend.domain.sigungu.SigunguDto;
import site.metacoding.animalprojectbackend.domain.sigungu.SigunguRepository;

@RequiredArgsConstructor
@Service
public class ShelterService {

    private final ShelterRepository shelterRepository;
    private final SigunguRepository sigunguRepository;

    public List<ShelterDto> 다운로드(ShelterDto shelterDto) {

        List<ShelterDto> lists = new ArrayList<>();
        List<SigunguDto> sigunguEntity = sigunguRepository.findAll();
        List<SigunguDto> findShelter = shelterRepository.findShelter();

        System.out.println(findShelter);

        RestTemplate restTemplate = new RestTemplate();
        ResponseDto response = new ResponseDto();

        try {
            for (int i = 0; i < sigunguEntity.size(); i++) {
                // 서비스키
                String key = "jDqHGG%2BaNG47ijh6s3XzB%2BuF8fJOeovccnw%2FZtc9wLQUaKJumPo%2Frl1a2ygZ68dv9L0PD7drvpjPAeTnnB9f%2FQ%3D%3D";

                StringBuffer urisb = new StringBuffer();
                urisb.append("http://apis.data.go.kr/1543061/abandonmentPublicSrvc/shelter?");
                urisb.append("serviceKey=" + key);
                urisb.append("&upr_cd=");
                urisb.append(findShelter.get(i).getUprCd()); // 시도 코드
                urisb.append("&org_cd=");
                urisb.append(findShelter.get(i).getOrgCd()); // 시군구 코드
                urisb.append("&_type=JSON");

                System.out.println(urisb.toString());

                URI uri = new URI(urisb.toString());

                response = restTemplate.getForObject(uri, ResponseDto.class);

                System.out.println(response);
            }

            List<ResponseDto> shelterList = new ArrayList<>();

            for (int i = 0; i < response.getResponse().getBody().getItems().getItem().size(); i++) {
                shelterList.add(response);
            }

            for (int i = 0; i < shelterList.size(); i++) {
                ShelterDto shelters = new ShelterDto(i,
                        shelterList.get(i).getResponse().getBody().getItems().getItem().get(i).getCareRegNo(),
                        shelterList.get(i).getResponse().getBody().getItems().getItem().get(i).getCareNm());

                lists.add(shelters);                
            }

            System.out.println(lists);

            List<ShelterDto> shelterEntity = shelterRepository.saveAll(lists);

            return shelterEntity;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
