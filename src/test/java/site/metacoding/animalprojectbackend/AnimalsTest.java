package site.metacoding.animalprojectbackend;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.jupiter.api.Test;
import org.qlrm.mapper.JpaResultMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import site.metacoding.animalprojectbackend.animalkind.modeling.KindDto;
import site.metacoding.animalprojectbackend.animalkind.modeling.KindRepository;
import site.metacoding.animalprojectbackend.domain.animals.Animals;
import site.metacoding.animalprojectbackend.domain.animals.dto.ResponseDto;
import site.metacoding.animalprojectbackend.domain.shelter.Shelter;
import site.metacoding.animalprojectbackend.domain.sigungu.Sigungu;
import site.metacoding.animalprojectbackend.domain.sigungu.SigunguRepository;

@RequiredArgsConstructor
@Service
public class AnimalsTest {
    
    private final EntityManager entityManager;
    private final SigunguRepository sigunguRepository;
    private final KindRepository kindRepository;

    @Test
    public List<Animals> 다운로드(Animals animals) {

        StringBuffer sb = new StringBuffer();
        sb.append("SELECT sg.orgCd, sg.uprCd, st.careRegNo "); // 시도, 시군구, 보호소 코드만 출력
        sb.append("FROM Sigungu sg ");
        sb.append("LEFT OUTER JOIN Sido si ON sg.uprCd = si.orgCd ");
        sb.append("LEFT OUTER JOIN Shelter st ON sg.id = st.id");

        Query query = entityManager.createQuery(sb.toString()); // 쿼리 완성
        JpaResultMapper resultMapper = new JpaResultMapper(); // 쿼리를 실행해줌, qlrm 라이브러리가 필요, class로 맵핑하기 위해서
        List<Sigungu> toSigungu = resultMapper.list(query, Sigungu.class); // 결과값 리스트에서 담음
        List<Shelter> toShelter = resultMapper.list(query, Shelter.class);

        List<Sigungu> sigunguEntity = sigunguRepository.findAll();
        List<KindDto> kindCdFindList = kindRepository.findKindCd();

        List<String> animalCode = new ArrayList<>(); // 축종코드 리스트
        animalCode.add("417000"); // 개
        animalCode.add("422400"); // 고양이
        animalCode.add("429900"); // 기타

        List<String> stateList = new ArrayList<>(); // 상태 리스트
        stateList.add("null"); // 빈값
        stateList.add("notice"); // 공고중
        stateList.add("protect"); // 보호중

        List<String> neuturList = new ArrayList<>(); // 중성화여부 리스트
        neuturList.add("null"); // 빈값
        neuturList.add("Y"); // 예
        neuturList.add("N"); // 아니오
        neuturList.add("U"); // 미상

        String firstDate = "20220319";
        String finishDate = "20220419";

        // 서비스키
        String key = "jDqHGG%2BaNG47ijh6s3XzB%2BuF8fJOeovccnw%2FZtc9wLQUaKJumPo%2Frl1a2ygZ68dv9L0PD7drvpjPAeTnnB9f%2FQ%3D%3D";

        try {
            RestTemplate restTemplate = new RestTemplate();
            List<Animals> shelterEntity = new ArrayList<>();
            List<Animals> lists = new ArrayList<>();
            ResponseDto response = new ResponseDto();

            for(int i = 0; i < sigunguEntity.size(); i++) {
                StringBuffer uriSb = new StringBuffer();
                uriSb.append("http://apis.data.go.kr/1543061/abandonmentPublicSrvc/abandonmentPublic?");
                uriSb.append("serviceKey=" + key); // 서비스키
                uriSb.append("&bgnde="); // 검색시작
                uriSb.append(firstDate);
                uriSb.append("&endde="); // 검색끝
                uriSb.append(finishDate);
                uriSb.append("&upkind="); // 축종코드
                uriSb.append(animalCode.get(i));
                uriSb.append("&kind="); // 품종
                uriSb.append(kindCdFindList.get(i).getKindCd());
                uriSb.append("&upr_cd="); // 시도
                uriSb.append(toSigungu.get(i).getUprCd());
                uriSb.append("&org_cd="); // 시군구
                uriSb.append(toSigungu.get(i).getOrgCd());
                uriSb.append("&care_reg_no="); // 보호소 번호
                uriSb.append(toShelter.get(i).getCareRegNo());
                uriSb.append("&state="); // 상태
                uriSb.append(stateList.get(i));
                uriSb.append("&neuter_yn="); // 중성화여부
                uriSb.append(neuturList.get(i));
                uriSb.append("&pageNo=1"); // 페이지 번호
                uriSb.append("&numOfRows=10"); // 페이지당 보여줄 갯수
                uriSb.append("&_type=JSON"); // 타입

                System.out.println(uriSb.toString());

                URI uri = new URI(uriSb.toString());

                response = restTemplate.getForObject(uri, ResponseDto.class);

                System.out.println("받은 데이터 ==========" + response);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
