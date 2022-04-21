package site.metacoding.animalprojectfrontend.web.api.dto.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SearchReqDto {
    private String region;
    private String type;
    private String title;
}
