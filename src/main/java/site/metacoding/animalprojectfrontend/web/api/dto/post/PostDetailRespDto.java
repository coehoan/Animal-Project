package site.metacoding.animalprojectfrontend.web.api.dto.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.animalprojectfrontend.domain.user.User;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostDetailRespDto {
    private Integer id;
    private String title;
    private String content;
    private String createDate;
    private User user;
    private Integer view;
    private Integer recommended;
}
