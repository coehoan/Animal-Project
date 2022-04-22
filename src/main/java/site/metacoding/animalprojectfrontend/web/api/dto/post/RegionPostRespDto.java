package site.metacoding.animalprojectfrontend.web.api.dto.post;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RegionPostRespDto {
    private Integer id;
    private String createDate;
    private String region;
    private String title;
    private String category;
    private String username;
    private Integer view;
    private Integer recommended;

    private List<RegionPostRespDto> regionPostRespDtos;
}
