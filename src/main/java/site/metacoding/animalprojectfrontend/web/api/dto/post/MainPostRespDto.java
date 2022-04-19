package site.metacoding.animalprojectfrontend.web.api.dto.post;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MainPostRespDto {
    private Integer id;
    private LocalDateTime createDate;
    private String title;
    private String username;

    private List<MainPostRespDto> postRespDtos;
}
