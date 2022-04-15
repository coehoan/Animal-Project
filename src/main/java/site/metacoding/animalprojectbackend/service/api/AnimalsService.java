package site.metacoding.animalprojectbackend.service.api;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.qlrm.mapper.JpaResultMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import site.metacoding.animalprojectbackend.animalkind.modeling.KindDto;
import site.metacoding.animalprojectbackend.animalkind.modeling.KindRepository;
import site.metacoding.animalprojectbackend.domain.animals.Animals;
import site.metacoding.animalprojectbackend.domain.animals.AnimalsRepository;
import site.metacoding.animalprojectbackend.domain.animals.dto.Item;
import site.metacoding.animalprojectbackend.domain.animals.dto.ResponseDto;
import site.metacoding.animalprojectbackend.domain.shelter.Shelter;
import site.metacoding.animalprojectbackend.domain.sigungu.Sigungu;
import site.metacoding.animalprojectbackend.domain.sigungu.SigunguRepository;

@RequiredArgsConstructor
@Service
public class AnimalsService {

    private final EntityManager entityManager;
    private final SigunguRepository sigunguRepository;
    private final KindRepository kindRepository;
    private final AnimalsRepository animalsRepository;

    public List<Animals> 다운로드(Animals animals) {

        StringBuffer sigunguSb = new StringBuffer();
        sigunguSb.append("SELECT sg.id, sg.orgCd, sg.orgdownNm, sg.uprCd "); // 시도, 시군구, 보호소 코드만 출력
        sigunguSb.append("FROM Sigungu sg ");
        sigunguSb.append("LEFT OUTER JOIN Sido si ON sg.uprCd = si.orgCd ");

        StringBuffer shelterSb = new StringBuffer();
        shelterSb.append("SELECT st.id, st.careNm, st.careRegNo ");
        shelterSb.append("FROM Sigungu sg ");
        shelterSb.append("LEFT OUTER JOIN Shelter st ON sg.id = st.id");

        Query sigungQuery = entityManager.createQuery(sigunguSb.toString()); // 쿼리 완성
        Query sheltQuery = entityManager.createQuery(shelterSb.toString()); // 쿼리 완성

        JpaResultMapper resultMapper = new JpaResultMapper(); // 쿼리를 실행해줌, qlrm 라이브러리가 필요, class로 맵핑하기 위해서
        List<Sigungu> toSigungu = resultMapper.list(sigungQuery, Sigungu.class); // 결과값 리스트에서 담음
        List<Shelter> toShelter = resultMapper.list(sheltQuery, Shelter.class);

        List<Sigungu> sigunguEntity = sigunguRepository.findAll();
        List<KindDto> kindCdFindList = kindRepository.findKindCd();

        List<String> animalCode = new ArrayList<>(); // 축종코드 리스트
        animalCode.add("417000"); // 개
        animalCode.add("422400"); // 고양이
        animalCode.add("429900"); // 기타

        List<String> stateList = new ArrayList<>(); // 상태 리스트
        stateList.add(""); // 빈값
        stateList.add("notice"); // 공고중
        stateList.add("protect"); // 보호중

        List<String> neuturList = new ArrayList<>(); // 중성화여부 리스트
        neuturList.add(""); // 빈값
        neuturList.add("Y"); // 예
        neuturList.add("N"); // 아니오
        neuturList.add("U"); // 미상

        String firstDate = "20210101";
        String finishDate = "20220415";

        // 서비스키
        String key = "jDqHGG%2BaNG47ijh6s3XzB%2BuF8fJOeovccnw%2FZtc9wLQUaKJumPo%2Frl1a2ygZ68dv9L0PD7drvpjPAeTnnB9f%2FQ%3D%3D";

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
}
