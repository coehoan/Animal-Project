package site.metacoding.animalprojectfrontend.domain.shelter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Header {

    private String reqNo;
    private String resultCode;
    private String resultMsg;
}
