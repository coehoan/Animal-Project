package site.metacoding.animalprojectbackend.domain.sigungu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Item {
    
    private String uprCd; // 상위 시도 코드
    private String orgCd; // 시군구 이름
    private String orgdownNm; // 시군구 코드
}
