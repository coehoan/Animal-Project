package site.metacoding.animalprojectbackend.animalkind.modeling;

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
public class KindDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String kindCd; // 동물 종류
    private String KNm; // 동물 품종

    // 개 : 417000, 고양이 : 422400, 기타 : 429900
}
