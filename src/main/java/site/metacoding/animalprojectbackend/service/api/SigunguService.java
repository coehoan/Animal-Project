package site.metacoding.animalprojectbackend.service.api;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import site.metacoding.animalprojectbackend.domain.sigungu.ResponseDto;
import site.metacoding.animalprojectbackend.domain.sigungu.SigunguDto;
import site.metacoding.animalprojectbackend.domain.sigungu.SigunguRepository;

@RequiredArgsConstructor
@Service
public class SigunguService {

    private final SigunguRepository sigunguRepository;

    public List<SigunguDto> 부산다운로드(SigunguDto sigunguDto) {
        List<SigunguDto> lists = new ArrayList<>();

        try {
            // 서비스키
            String key = "jDqHGG%2BaNG47ijh6s3XzB%2BuF8fJOeovccnw%2FZtc9wLQUaKJumPo%2Frl1a2ygZ68dv9L0PD7drvpjPAeTnnB9f%2FQ%3D%3D";

            // 시도 코드에 따른 변수들
            String busan = "6260000";
            String deagu = "6270000";
            String incheon = "6280000";
            String gwangju = "6290000";
            String seajong = "5690000";

            StringBuffer urisb = new StringBuffer();
            urisb.append("http://apis.data.go.kr/1543061/abandonmentPublicSrvc/sigungu?");
            urisb.append("serviceKey=" + key);
            urisb.append("&upr_cd=");
            urisb.append(busan);
            urisb.append("&_type=JSON");

            URI uri = new URI(urisb.toString()); // 반드시 URI로 만들어주고 주소 요청하기
            // 안 그러면 header의 MIME 타입이 text/plain으로 된다.

            RestTemplate restTemplate = new RestTemplate();

            ResponseDto response = restTemplate.getForObject(uri, ResponseDto.class);

            System.out.println(response);

            List<ResponseDto> sigunguList = new ArrayList<>();

            for (int i = 0; i < response.getResponse().getBody().getItems().getItem().size(); i++) {
                sigunguList.add(response);
            }

            System.out.println(sigunguList);

            for (int i = 0; i < sigunguList.size(); i++) {
                SigunguDto result = new SigunguDto(i,
                sigunguList.get(i).getResponse().getBody().getItems().getItem().get(i).getOrgCd(),
                sigunguList.get(i).getResponse().getBody().getItems().getItem().get(i).getOrgdownNm(),
                sigunguList.get(i).getResponse().getBody().getItems().getItem().get(i).getUprCd());

                lists.add(result);
            }

            System.out.println(lists);

            List<SigunguDto> sigunguEntity = sigunguRepository.saveAll(lists);

            return sigunguEntity;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Transactional
    public List<SigunguDto> 대구다운로드(SigunguDto sigunguDto) {

        List<SigunguDto> lists = new ArrayList<>();

        try {
            // 서비스키
            String key = "jDqHGG%2BaNG47ijh6s3XzB%2BuF8fJOeovccnw%2FZtc9wLQUaKJumPo%2Frl1a2ygZ68dv9L0PD7drvpjPAeTnnB9f%2FQ%3D%3D";

            // 시도 코드에 따른 변수들
            String busan = "6260000";
            String deagu = "6270000";
            String incheon = "6280000";
            String gwangju = "6290000";
            String seajong = "5690000";

            StringBuffer urisb = new StringBuffer();
            urisb.append("http://apis.data.go.kr/1543061/abandonmentPublicSrvc/sigungu?");
            urisb.append("serviceKey=" + key);
            urisb.append("&upr_cd=");
            urisb.append(deagu);
            urisb.append("&_type=JSON");

            URI uri = new URI(urisb.toString());

            RestTemplate restTemplate = new RestTemplate();

            ResponseDto response = restTemplate.getForObject(uri, ResponseDto.class);

            System.out.println(response);

            List<ResponseDto> sigunguList = new ArrayList<>();

            for (int i = 0; i < response.getResponse().getBody().getItems().getItem().size(); i++) {
                sigunguList.add(response);
            }

            System.out.println(sigunguList);

            for (int i = 0; i < sigunguList.size(); i++) {
                SigunguDto result = new SigunguDto(i,
                sigunguList.get(i).getResponse().getBody().getItems().getItem().get(i).getOrgCd(),
                sigunguList.get(i).getResponse().getBody().getItems().getItem().get(i).getOrgdownNm(),
                sigunguList.get(i).getResponse().getBody().getItems().getItem().get(i).getUprCd());

                lists.add(result);
            }

            System.out.println(lists);

            List<SigunguDto> sigunguEntity = sigunguRepository.saveAll(lists);

            return sigunguEntity;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Transactional
    public List<SigunguDto> 인천다운로드(SigunguDto sigunguDto) {

        List<SigunguDto> lists = new ArrayList<>();

        try {
            // 서비스키
            String key = "jDqHGG%2BaNG47ijh6s3XzB%2BuF8fJOeovccnw%2FZtc9wLQUaKJumPo%2Frl1a2ygZ68dv9L0PD7drvpjPAeTnnB9f%2FQ%3D%3D";

            // 시도 코드에 따른 변수들
            String busan = "6260000";
            String deagu = "6270000";
            String incheon = "6280000";
            String gwangju = "6290000";
            String seajong = "5690000";

            StringBuffer urisb = new StringBuffer();
            urisb.append("http://apis.data.go.kr/1543061/abandonmentPublicSrvc/sigungu?");
            urisb.append("serviceKey=" + key);
            urisb.append("&upr_cd=");
            urisb.append(incheon);
            urisb.append("&_type=JSON");

            URI uri = new URI(urisb.toString());

            RestTemplate restTemplate = new RestTemplate();

            ResponseDto response = restTemplate.getForObject(uri, ResponseDto.class);

            System.out.println(response);

            List<ResponseDto> sigunguList = new ArrayList<>();

            for (int i = 0; i < response.getResponse().getBody().getItems().getItem().size(); i++) {
                sigunguList.add(response);
            }

            System.out.println(sigunguList);

            for (int i = 0; i < sigunguList.size(); i++) {
                SigunguDto result = new SigunguDto(i,
                sigunguList.get(i).getResponse().getBody().getItems().getItem().get(i).getOrgCd(),
                sigunguList.get(i).getResponse().getBody().getItems().getItem().get(i).getOrgdownNm(),
                sigunguList.get(i).getResponse().getBody().getItems().getItem().get(i).getUprCd());

                lists.add(result);
            }

            System.out.println(lists);

            List<SigunguDto> sigunguEntity = sigunguRepository.saveAll(lists);

            return sigunguEntity;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
