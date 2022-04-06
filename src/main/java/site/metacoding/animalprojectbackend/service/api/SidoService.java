package site.metacoding.animalprojectbackend.service.api;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import site.metacoding.animalprojectbackend.domain.sido.ResponseDto;
import site.metacoding.animalprojectbackend.domain.sido.SidoDto;
import site.metacoding.animalprojectbackend.domain.sido.SidoRepository;

@RequiredArgsConstructor
@Service
public class SidoService {
    
    private final SidoRepository sidoRepository;

    @Transactional
    public List<SidoDto> 다운로드(SidoDto sidoDto) {


        List<SidoDto> lists = new ArrayList<>();

        try {
            String key = "jDqHGG%2BaNG47ijh6s3XzB%2BuF8fJOeovccnw%2FZtc9wLQUaKJumPo%2Frl1a2ygZ68dv9L0PD7drvpjPAeTnnB9f%2FQ%3D%3D";
            URI uri = new URI(
                    "http://apis.data.go.kr/1543061/abandonmentPublicSrvc/sido?serviceKey=" + key
                            + "&numOfRows=3&pageNo=1&_type=JSON");
            RestTemplate restTemplate = new RestTemplate();

            ResponseDto response = restTemplate.getForObject(uri, ResponseDto.class);

            System.out.println(response);

            List<ResponseDto> sidoList = new ArrayList<>();


            String totalCount = response.getResponse().getBody().getTotalCount(); // totalcount 받기

            key = "jDqHGG%2BaNG47ijh6s3XzB%2BuF8fJOeovccnw%2FZtc9wLQUaKJumPo%2Frl1a2ygZ68dv9L0PD7drvpjPAeTnnB9f%2FQ%3D%3D";
            uri = new URI(
                    "http://apis.data.go.kr/1543061/abandonmentPublicSrvc/sido?serviceKey=" + key
                            + "&numOfRows=" + totalCount + "&pageNo=1&_type=JSON");
            restTemplate = new RestTemplate();

            response = restTemplate.getForObject(uri, ResponseDto.class);

            for(int i = 0; i < response.getResponse().getBody().getItems().getItem().size(); i++) {
                sidoList.add(response);
            }

            System.out.println(sidoList);

            for (int i = 0; i < sidoList.size(); i++) {
                SidoDto result = new SidoDto(i,
                        sidoList.get(i).getResponse().getBody().getItems().getItem().get(i).getOrgCd(),
                        sidoList.get(i).getResponse().getBody().getItems().getItem().get(i).getOrgdownNm());

                lists.add(result);
            }

            System.out.println(lists);

            List<SidoDto> sidoEntity = sidoRepository.saveAll(lists);

            return sidoEntity;

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return null;
    }
}
