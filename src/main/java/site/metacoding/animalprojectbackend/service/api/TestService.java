package site.metacoding.animalprojectbackend.service.api;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import site.metacoding.animalprojectbackend.domain.sido.Sido;
import site.metacoding.animalprojectbackend.domain.sido.SidoRepository;
import site.metacoding.animalprojectbackend.domain.sigungu.Sigungu;
import site.metacoding.animalprojectbackend.domain.sigungu.SigunguRepository;
import site.metacoding.animalprojectbackend.domain.sigungu.dto.Item;
import site.metacoding.animalprojectbackend.domain.sigungu.dto.ResponseDto;

@RequiredArgsConstructor
@Service
public class TestService {

    private final SidoRepository sidoRepository;
    private final SigunguRepository sigunguRepository;

    @Transactional
    public List<Sigungu> 테스트(Sigungu sigungu) {

        List<Sido> sidoRepo = sidoRepository.findCd(); // 시도 코드만 찾기
        // List<SidoDto> sidoEntity = sidoRepository.findAll(); // 시도 모두 찾기
        // Set<SidoDto> sidoHash = sidoRepository.findCdHash();

        RestTemplate restTemplate = new RestTemplate();

        // 서비스키
        String key = "jDqHGG%2BaNG47ijh6s3XzB%2BuF8fJOeovccnw%2FZtc9wLQUaKJumPo%2Frl1a2ygZ68dv9L0PD7drvpjPAeTnnB9f%2FQ%3D%3D";

        // 시도 코드에 따른 변수들
        // String gwangju = "6290000";
        // String busan = "6260000";

        // for (int i = 0; i < sidoEntity.size(); i++) { // 시도 사이즈만큼 반복
        List<ResponseDto> sigunguList = new ArrayList<>();
        List<Sigungu> lists = new ArrayList<>();
        List<Sigungu> sigunguEntity = new ArrayList<>();

        try {
            ResponseDto response = new ResponseDto();
            for (int p = 0; p < sidoRepo.size(); p++) {
                StringBuffer urisb = new StringBuffer();
                urisb.append("http://apis.data.go.kr/1543061/abandonmentPublicSrvc/sigungu?");
                urisb.append("serviceKey=" + key);
                urisb.append("&upr_cd=");
                urisb.append(sidoRepo.get(p).getOrgCd());
                urisb.append("&_type=JSON");

                System.out.println(urisb.toString());

                URI uri = new URI(urisb.toString());

                response = restTemplate.getForObject(uri, ResponseDto.class);

                System.out.println("처음에 다운로드 받은 것 =======" + response); // 여기에서 null 떠서 캐치로 감

                if (response.getResponse().getBody().getItems().getItem() != null) {

                    List<Item> itemList = response.getResponse().getBody().getItems().getItem();
                    System.out.println("처음에 리스트에서 넣은 것 ========" + itemList);

                    for (int i = 0; i < itemList.size(); i++) {

                        System.out.println("아이템 사이즈 확인 =====" + itemList.size());
                        Sigungu sigungus = Sigungu.builder()
                        .orgCd(itemList.get(i).getOrgCd())
                        .orgdownNm(itemList.get(i).getOrgdownNm())
                        .uprCd(itemList.get(i).getUprCd())
                        .build();
                        // sigungus.setId(i);
                        // sigungus.setOrgCd(itemList.get(i).getOrgCd());
                        // sigungus.setOrgdownNm(itemList.get(i).getOrgdownNm());
                        // sigungus.setUprCd(itemList.get(i).getUprCd());

                        lists.add(sigungus);

                        sigunguEntity = sigunguRepository.saveAllAndFlush(lists);

                        System.out.println("엔티티에 들어간 것 확인 ======" + lists);

                    }

                }

            }
            return sigunguEntity;

            // System.out.println("처음에 엔티티에 받은 것 =======" + lists);

        } catch (Exception e) {
            e.printStackTrace();

            // try {
            // ResponseDto response = new ResponseDto();
            // for (int p = 0; p < sidoRepo.size(); p++) {
            // StringBuffer urisb = new StringBuffer();
            // urisb.append("http://apis.data.go.kr/1543061/abandonmentPublicSrvc/sigungu?");
            // urisb.append("serviceKey=" + key);
            // urisb.append("&upr_cd=");
            // urisb.append(sidoRepo.get(p).getOrgCd());
            // urisb.append("&_type=JSON");

            // System.out.println(urisb.toString());

            // URI uri = new URI(urisb.toString());

            // response = restTemplate.getForObject(uri, ResponseDto.class);

            // List<Item> itemList = response.getResponse().getBody().getItems().getItem();

            // sigunguList.add(response);

            // System.out.println("두 번째로 다운로드 받은 것 =======" + response); // 여기에서 null 떠서 캐치로
            // 감

            // for (int i = 0; i < itemList.size(); i++) {
            // Sigungu sigungus = new Sigungu(i, itemList.get(i).getUprCd(),
            // itemList.get(i).getOrgCd(),
            // itemList.get(i).getOrgdownNm());

            // lists.add(sigungus);
            // }
            // }

            // // System.out.println("스택 빠져나왔을 때 response========" + response);

            // } catch (Exception o) {
            // o.printStackTrace();

            // }
            // System.out.println("다운로드 받은 것 ========" + sigunguList);

        }
        return null;

    }
}
// 한 대여섯번 반복하지만 일단 다 나오긴 함(근데 다운이 안되네...;;)
