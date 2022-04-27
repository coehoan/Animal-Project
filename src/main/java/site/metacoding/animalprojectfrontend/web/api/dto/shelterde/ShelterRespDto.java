package site.metacoding.animalprojectfrontend.web.api.dto.shelterde;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ShelterRespDto {
    private Integer id;
    private String orgNm;
    private String careNm;
    private String careAddr;
    private String weekOprStime;
    private String weekOprEtime;
    private String closeDay;
    private String careTel;
    private String saveTrgtAnimal;
}
