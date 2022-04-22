package site.metacoding.animalprojectfrontend.web.api.dto.animals;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseDto<T> {
    
    private Integer code; // 1 성공, -1 실패
    private String msg;
    private T data;
}
