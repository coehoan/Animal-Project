package site.metacoding.animalprojectbackend.service.api;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import site.metacoding.animalprojectbackend.domain.sigungu.ResponseDto;
import site.metacoding.animalprojectbackend.domain.sigungu.SigunguDto;
import site.metacoding.animalprojectbackend.domain.sigungu.SigunguRepository;

@RequiredArgsConstructor
@Service
public class SigunguService {

    private final SigunguRepository sigunguRepository;

    public List<SigunguDto> 다운로드(SigunguDto sigunguDto) {
        List<SigunguDto> lists = new ArrayList<>();

        try {
            String key = "jDqHGG%2BaNG47ijh6s3XzB%2BuF8fJOeovccnw%2FZtc9wLQUaKJumPo%2Frl1a2ygZ68dv9L0PD7drvpjPAeTnnB9f%2FQ%3D%3D";
            URI uri = new URI(
                    "http://apis.data.go.kr/1543061/abandonmentPublicSrvc/sido?serviceKey=" + key
                            + "&numOfRows=3&pageNo=1&_type=JSON");
            RestTemplate restTemplate = new RestTemplate();

            ResponseDto response = restTemplate.getForObject(uri, ResponseDto.class);

            System.out.println(response);

            List<ResponseDto> sidoList = new ArrayList<>();

            for (int i = 0; i < response.getResponse().getBody().getItems().getItem().size(); i++) {
                sidoList.add(response);
            }

            System.out.println(sidoList);

            for (int i = 0; i < sidoList.size(); i++) {
                SigunguDto result = new SigunguDto(i,
                        sidoList.get(i).getResponse().getBody().getItems().getItem().get(i).getOrgCd(),
                        sidoList.get(i).getResponse().getBody().getItems().getItem().get(i).getOrgdownNm(),
                        sidoList.get(i).getResponse().getBody().getItems().getItem().get(i).getUprCd());

                lists.add(result);
            }

            System.out.println(lists);

            List<SigunguDto> sigunguEntity = sigunguRepository.saveAll(lists);

            return sigunguEntity;

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
}
