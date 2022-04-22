package site.metacoding.animalprojectfrontend.web.api.dto.post;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MainPostRespDto {
    private Integer id;
    private String createDate;
    private String title;
    private String username;

    private List<MainPostRespDto> postRespDtos;
}
