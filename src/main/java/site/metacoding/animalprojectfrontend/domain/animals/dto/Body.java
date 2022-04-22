package site.metacoding.animalprojectfrontend.domain.animals.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Body {
    
    private Items items;
    private Integer numOfRows; // 한 페이지 결과 수
    private Integer pageNo; // 페이지 넘버 수
    private Integer totalCount; // 전체결과 수 
}
