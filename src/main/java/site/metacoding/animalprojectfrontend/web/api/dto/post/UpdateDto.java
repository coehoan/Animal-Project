package site.metacoding.animalprojectfrontend.web.api.dto.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateDto {
    private Integer id;
    private String title;
    private String content;
    private String board;
}
