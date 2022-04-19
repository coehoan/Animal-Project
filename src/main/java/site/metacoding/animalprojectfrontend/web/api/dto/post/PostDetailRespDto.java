package site.metacoding.animalprojectfrontend.web.api.dto.post;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.animalprojectfrontend.domain.user.User;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostDetailRespDto {
    private String title;
    private String content;
    private LocalDateTime createDate;
    private User user;
    private Integer view;
    private Integer recommended;
}
