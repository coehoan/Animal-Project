package site.metacoding.animalprojectbackend.animalkind.kindservice;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import site.metacoding.animalprojectbackend.animalkind.modeling.Item;
import site.metacoding.animalprojectbackend.animalkind.modeling.Kind;
import site.metacoding.animalprojectbackend.animalkind.modeling.KindDto;
import site.metacoding.animalprojectbackend.animalkind.modeling.KindRepository;
import site.metacoding.animalprojectbackend.animalkind.modeling.ResponseDto;

@RequiredArgsConstructor
@Service
public class KindService {
    private final KindRepository kindRepository;

    @Transactional
    public List<Kind> 다운로드(KindDto kindDto) {
        String key = "jDqHGG%2BaNG47ijh6s3XzB%2BuF8fJOeovccnw%2FZtc9wLQUaKJumPo%2Frl1a2ygZ68dv9L0PD7drvpjPAeTnnB9f%2FQ%3D%3D";
        RestTemplate restTemplate = new RestTemplate();

        List<Kind> lists = new ArrayList<>();
        List<Kind> kindEntity = new ArrayList<>();
        ArrayList<String> kindLists = new ArrayList<String>();
        kindLists.add("417000");
        kindLists.add("422400");
        kindLists.add("429900");
        try {
            for (String str : kindLists) {
                StringBuffer urisb = new StringBuffer();
                urisb.append(
                        "http://apis.data.go.kr/1543061/abandonmentPublicSrvc/kind?");
                urisb.append("serviceKey=" + key);
                urisb.append("&up_kind_cd=" + str);
                urisb.append("&_type=json");

                URI uri = new URI(urisb.toString());
                // 개 : 417000, 고양이 : 422400, 기타 : 429900

                ResponseDto response = restTemplate.getForObject(uri, ResponseDto.class);

                System.out.println(response);
                if (response.getResponse().getBody().getItems().getItem() != null) {
                    List<Item> itemList = response.getResponse().getBody().getItems().getItem();
                    System.out.println(itemList);

                    for (int i = 0; i < itemList.size(); i++) {
                        Kind result = Kind.builder()
                                .KNm(itemList.get(i).getKNm())
                                .kindCd(itemList.get(i).getKindCd())
                                .build();

                        lists.add(result);

                        kindEntity = kindRepository.saveAllAndFlush(lists);

                        System.out.println(lists);

                    }
                }
            }
            return kindEntity;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
