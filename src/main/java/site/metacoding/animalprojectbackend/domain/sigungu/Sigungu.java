package site.metacoding.animalprojectbackend.domain.sigungu;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Sigungu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = true)
    private String uprCd; // 상위 시도 코드

    @Column(nullable = true)
    private String orgCd; // 시군구 코드

    @Column(nullable = true)
    private String orgdownNm; // 시군구 이름

}
