package site.metacoding.animalprojectfrontend.service.api;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import site.metacoding.animalprojectfrontend.domain.animals.Animals;
import site.metacoding.animalprojectfrontend.domain.animals.AnimalsRepository;
import site.metacoding.animalprojectfrontend.domain.animals.dto.Item;
import site.metacoding.animalprojectfrontend.domain.animals.dto.ResponseDto;
import site.metacoding.animalprojectfrontend.domain.user.UserRepository;
import site.metacoding.animalprojectfrontend.web.api.dto.animals.MainRespDto;

@RequiredArgsConstructor
@Service
public class AnimalsService {

    private final HttpSession httpSession;
    private final AnimalsRepository animalsRepository;
    private final UserRepository userRepository;
    private final HttpServletRequest request;
    private final EntityManager em;

    public List<Animals> 다운로드() {

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

            response = restTemplate.getForObject(uri, ResponseDto.class);

            Integer totalCount = response.getResponse().getBody().getTotalCount();

            Integer result = totalCount / 1000; // totalCount를 1000씩으로 나눔, 최대 요청숫자가 1000이라서...
            for (int i = 0; i < result; i++) {

                if (response.getResponse().getBody().getItems().getItem() != null) {

                    List<Item> itemList = response.getResponse().getBody().getItems().getItem().stream().distinct()
                            .collect(Collectors.toList());

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

                    }
                }

            }

            return animalsEntity;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<MainRespDto> 메인동물목록() {
        List<MainRespDto> animalsEntity = new ArrayList<>();

        String sql = "SELECT filename, age, careNm, sexCd FROM Animals ORDER BY RAND()";
        Query query = em.createQuery(sql).setMaxResults(4);

        List<Object[]> results = (List<Object[]>) query.getResultList();

        for (Object[] result : results) {
            String filename = (String) result[0];
            String age = (String) result[1];
            String careNm = (String) result[2];
            String sexCd = (String) result[3];

            MainRespDto dto = new MainRespDto(filename, age, careNm, sexCd);
            animalsEntity.add(dto);
        }
        return animalsEntity;
    }

    public List<Animals> 전체검색(String keywordOfkind,
            String keywordOfkindOf, String keywordOfSido,
            String keywordOfSigungu,
            String keywordOfirstDate,
            String keywordOflastDate) {

        List<Animals> findRegionEntity = animalsRepository.keywordOfAll(keywordOfkind, keywordOfkindOf, keywordOfSido,
                keywordOfSigungu, keywordOfirstDate, keywordOflastDate);
        return findRegionEntity;

    }

    public List<Animals> 지역검색(String keywordOfSido, String keywordOfSigungu) {

        List<Animals> findRegionEntity = animalsRepository.keywordOfRegion(keywordOfSido, keywordOfSigungu);
        return findRegionEntity;

    }

    public List<Animals> 지역검색시도(String keywordOfSido) {

        List<Animals> findRegionEntity = animalsRepository.keywordOfRegionSido(keywordOfSido);
        return findRegionEntity;

    }

    public List<Animals> 품종검색(String keywordOfkind, String keywordOfkindOf) {

        List<Animals> findKindEntity = animalsRepository.keywordOfKind(keywordOfkind, keywordOfkindOf);
        return findKindEntity;

    }

    public List<Animals> 품종검색품종만(String keywordOfkind) {

        List<Animals> findKindEntity = animalsRepository.keywordOfKindOnly(keywordOfkind);
        return findKindEntity;

    }

    public List<Animals> 날짜검색(String keywordOfirstDate, String keywordOflastDate) {

        // String[] firstDate = keywordOfirstDate.split("-");
        // System.out.println(firstDate);
        // StringBuilder fDsb = new StringBuilder();

        // fDsb.append(firstDate[0]);
        // fDsb.append(firstDate[1]);
        // fDsb.append(firstDate[2]);

        // System.out.println(fDsb.toString());

        // String[] lastDate = keywordOfirstDate.split("-");
        // StringBuilder lDsb = new StringBuilder();
        // System.out.println(lastDate[0]);
        // lDsb.append(lastDate[0]);
        // lDsb.append(lastDate[1]);
        // lDsb.append(lastDate[2]);
        // System.out.println(lDsb.toString());
        // 컨트롤러에서 해줘서 안 해도 됨!

        List<Animals> findDayEntity = animalsRepository.keywordOfDay(keywordOfirstDate, keywordOflastDate);
        return findDayEntity;

    }

    ///////////////////// 유저 검색

    public List<Animals> 유저검색(String userRegion) {
        List<Animals> forUserEntity = animalsRepository.forUser(userRegion);
        return forUserEntity;

    }

}
