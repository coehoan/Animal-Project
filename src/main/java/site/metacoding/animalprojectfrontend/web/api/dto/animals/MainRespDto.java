package site.metacoding.animalprojectfrontend.web.api.dto.animals;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MainRespDto {
    private String filename;
    private String age;
    private String careNm;
    private String sexCd;
}
