package site.metacoding.animalprojectbackend.animalkind.kindservice;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import site.metacoding.animalprojectbackend.animalkind.modeling.KindDto;
import site.metacoding.animalprojectbackend.animalkind.modeling.KindRepository;
import site.metacoding.animalprojectbackend.animalkind.modeling.ResponseDto;

@RequiredArgsConstructor
@Service
public class KindService {
    private final KindRepository kindRepository;

    @Transactional
    public List<KindDto> 다운로드(KindDto kindDto) {

        List<KindDto> lists = new ArrayList<>();

        try {
            String key = "jDqHGG%2BaNG47ijh6s3XzB%2BuF8fJOeovccnw%2FZtc9wLQUaKJumPo%2Frl1a2ygZ68dv9L0PD7drvpjPAeTnnB9f%2FQ%3D%3D";
            URI uri = new URI(
                    "http://apis.data.go.kr/1543061/abandonmentPublicSrvc/kind?serviceKey="
                            + key + "&up_kind_cd=417000&_type=json");
            // 개 : 417000, 고양이 : 422400, 기타 : 429900
            RestTemplate restTemplate = new RestTemplate();

            ResponseDto response = restTemplate.getForObject(uri, ResponseDto.class);

            System.out.println(response);

            List<ResponseDto> kindList = new ArrayList<>();

            for (int i = 0; i < response.getResponse().getBody().getItems().getItem().size(); i++) {
                kindList.add(response);
            }
            System.out.println(kindList);

            for (int i = 0; i < kindList.size(); i++) {
                KindDto result = new KindDto(i,
                        kindList.get(i).getResponse().getBody().getItems().getItem().get(i).getKindCd(),
                        kindList.get(i).getResponse().getBody().getItems().getItem().get(i).getKNm());
                lists.add(result);
            }

            System.out.println(lists);

            List<KindDto> kindEntity = kindRepository.saveAll(lists);

            return kindEntity;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
