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
import site.metacoding.animalprojectbackend.domain.shelter.Shelter;
import site.metacoding.animalprojectbackend.domain.shelter.ShelterRepository;
import site.metacoding.animalprojectbackend.domain.shelter.dto.Item;
import site.metacoding.animalprojectbackend.domain.shelter.dto.ResponseDto;
import site.metacoding.animalprojectbackend.domain.sigungu.Sigungu;
import site.metacoding.animalprojectbackend.domain.sigungu.SigunguRepository;

@RequiredArgsConstructor
@Service
public class ShelterService {

    private final ShelterRepository shelterRepository;
    private final SigunguRepository sigunguRepository;
    private final EntityManager entityManager; // entity를 관리하는 클래스

    public List<Shelter> 다운로드(Shelter shelter) {

        StringBuffer sb = new StringBuffer(); // 쿼리문 짜기
        sb.append("SELECT sg.id, sg.uprCd, sg.orgCd, sg.orgdownNm ");
        sb.append("FROM Sido sd ");
        sb.append("INNER JOIN Sigungu sg ");
        sb.append("ON sd.orgCd = sg.uprCd");

        Query query = entityManager.createQuery(sb.toString()); // 쿼리 완성

        JpaResultMapper resultMapper = new JpaResultMapper(); // 쿼리를 실행해줌, qlrm 라이브러리가 필요, class로 맵핑하기 위해서
        List<Sigungu> sigungus = resultMapper.list(query, Sigungu.class);


        List<Sigungu> sigunguEntity = sigunguRepository.findAll();


        // 서비스키
        String key = "jDqHGG%2BaNG47ijh6s3XzB%2BuF8fJOeovccnw%2FZtc9wLQUaKJumPo%2Frl1a2ygZ68dv9L0PD7drvpjPAeTnnB9f%2FQ%3D%3D";

        try {
            RestTemplate restTemplate = new RestTemplate();
            List<Shelter> shelterEntity = new ArrayList<>();
            List<Shelter> lists = new ArrayList<>();
            ResponseDto response = new ResponseDto();

            for (int i = 0; i < sigunguEntity.size(); i++) {
                StringBuffer urisb = new StringBuffer();
                urisb.append("http://apis.data.go.kr/1543061/abandonmentPublicSrvc/shelter?");
                urisb.append("serviceKey=" + key);
                urisb.append("&upr_cd=");
                urisb.append(sigungus.get(i).getUprCd()); // 시도 코드
                urisb.append("&org_cd=");
                urisb.append(sigungus.get(i).getOrgCd()); // 시군구 코드
                urisb.append("&_type=JSON");

                URI uri = new URI(urisb.toString());

                response = restTemplate.getForObject(uri, ResponseDto.class);

                System.out.println("다운로드 받은 데이터 =======" + response);

                if (response.getResponse().getBody().getItems().getItem() != null) {

                    List<Item> itemList = response.getResponse().getBody().getItems().getItem();

                    for (int o = 0; o < itemList.size(); o++) {
                        Shelter shelters = Shelter.builder()
                        .careNm(itemList.get(o).getCareNm())
                        .careRegNo(itemList.get(o).getCareRegNo())
                        .build();
                        // shelter.setId(o);
                        // shelter.setCareNm(itemList.get(o).getCareNm());
                        // shelter.setCareRegNo(itemList.get(o).getCareRegNo());

                        lists.add(shelters);

                        shelterEntity = shelterRepository.saveAllAndFlush(lists);

                        System.out.println("받은 엔티티=======" + lists);
                    }

                }

            }

            return shelterEntity;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
