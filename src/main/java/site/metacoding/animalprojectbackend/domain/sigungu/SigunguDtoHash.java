package site.metacoding.animalprojectbackend.domain.sigungu;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class SigunguDtoHash {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String hash;
    private String uprCd; // 상위 시도 코드
    private String orgCd; // 시군구 코드
    private String orgdownNm; // 시군구 이름

}
