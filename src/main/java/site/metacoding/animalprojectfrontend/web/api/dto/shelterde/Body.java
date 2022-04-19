package site.metacoding.animalprojectfrontend.web.api.dto.shelterde;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Body {

    private Items items;
    private String numOfRows;
    private String pageNo;
    private Integer totalCount;

}
