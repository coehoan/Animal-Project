package site.metacoding.animalprojectbackend.domain.shelter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Item {
    
    private String careRegNo; // 보호소 넘버
    private String careNm; // 보호소 이름
}
