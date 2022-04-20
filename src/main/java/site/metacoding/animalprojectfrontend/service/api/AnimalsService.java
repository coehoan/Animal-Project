package site.metacoding.animalprojectfrontend.service.api;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import site.metacoding.animalprojectfrontend.domain.animals.Animals;
import site.metacoding.animalprojectfrontend.domain.animals.AnimalsRepository;
import site.metacoding.animalprojectfrontend.domain.animals.dto.Item;
import site.metacoding.animalprojectfrontend.domain.animals.dto.ResponseDto;

@RequiredArgsConstructor
@Service
public class AnimalsService {

    private final EntityManager entityManager;
    private final AnimalsRepository animalsRepository;

    public List<Animals> 다운로드(Animals animals) {

        // 서비스키
        String key = "jDqHGG%2BaNG47ijh6s3XzB%2BuF8fJOeovccnw%2FZtc9wLQUaKJumPo%2Frl1a2ygZ68dv9L0PD7drvpjPAeTnnB9f%2FQ%3D%3D";

        String firstDate = "20210101";
        String finishDate = "20220415";

        try {
            RestTemplate restTemplate = new RestTemplate();
            List<Animals> animalsEntity = new ArrayList<>();
            List<Animals> lists = new ArrayList<>();
            ResponseDto response = new ResponseDto();

            StringBuffer uriSb = new StringBuffer();
            uriSb.append("http://apis.data.go.kr/1543061/abandonmentPublicSrvc/abandonmentPublic?");
            uriSb.append("serviceKey=" + key); // 서비스키
            uriSb.append("&bgnde="); // 검색시작
            uriSb.append(firstDate);
            uriSb.append("&endde="); // 검색끝
            uriSb.append(finishDate);
            uriSb.append("&pageNo=1"); // 페이지 번호
            uriSb.append("&numOfRows=1000"); // 페이지당 보여줄 갯수
            uriSb.append("&_type=JSON"); // 타입

            URI uri = new URI(uriSb.toString());

            // System.out.println("요청한 주소 ======= " + uri);

            response = restTemplate.getForObject(uri, ResponseDto.class);

            // System.out.println("받은 데이터 ==========" + response);

            Integer totalCount = response.getResponse().getBody().getTotalCount();

            Integer result = totalCount / 1000; // totalCount를 1000씩으로 나눔, 최대 요청숫자가 1000이라서...

            for (int i = 0; i < totalCount / 142; i++) {

                if (response.getResponse().getBody().getItems().getItem() != null) {

                    List<Item> itemList = response.getResponse().getBody().getItems().getItem();

                    for (int o = 0; o < itemList.size(); o++) {
                        Animals toAnimals = Animals.builder()
                                .filename(itemList.get(o).getFilename())
                                .popfile(itemList.get(o).getPopfile())
                                .age(itemList.get(o).getAge())
                                .careAddr(itemList.get(o).getCareAddr())
                                .careNm(itemList.get(o).getCareNm())
                                .careTel(itemList.get(o).getCareTel())
                                .chargeNm(itemList.get(o).getChargeNm())
                                .colorCd(itemList.get(o).getColorCd())
                                .desertionNo(itemList.get(o).getDesertionNo())
                                .happenDt(itemList.get(o).getHappenDt())
                                .happenPlace(itemList.get(o).getHappenPlace())
                                .kindCd(itemList.get(o).getKindCd())
                                .neuterYn(itemList.get(o).getNeuterYn())
                                .noticeComment(itemList.get(o).getNoticeComment())
                                .noticeEdt(itemList.get(o).getNoticeEdt())
                                .noticeNo(itemList.get(o).getNoticeNo())
                                .noticeSdt(itemList.get(o).getNoticeSdt())
                                .officetel(itemList.get(o).getOfficetel())
                                .orgNm(itemList.get(o).getOrgNm())
                                .processState(itemList.get(o).getProcessState())
                                .sexCd(itemList.get(o).getSexCd())
                                .specialMark(itemList.get(o).getSpecialMark())
                                .weight(itemList.get(o).getWeight())
                                .build();

                        lists.add(toAnimals);

                        animalsEntity = animalsRepository.saveAllAndFlush(lists);

                        System.out.println("받은 엔티티 =========" + lists);

                    }
                }

            }

            return animalsEntity;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Animals> 전체검색() {
        List<Animals> findAllEntity = animalsRepository.findAll();

        return findAllEntity;
    }

    public List<Animals> 지역검색(String keywordOfSido, String keywordOfSigungu) {
        System.out.println("쿼리스트링 받아졌나?" + keywordOfSido + keywordOfSigungu);
        
        if (animalsRepository.keywordOfRegion(keywordOfSido, keywordOfSigungu) != null) {
            List<Animals> findRegionEntity = animalsRepository.keywordOfRegion(keywordOfSido, keywordOfSigungu);
            System.out.println("서비스 잘 되나?=======" + findRegionEntity);
            return findRegionEntity;
        } else {
            return null;
        }

        
    }
}
