package site.metacoding.animalprojectfrontend.web.api.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.animalprojectfrontend.domain.comment.Comment;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommentRespDto {
    private Comment content;
    private boolean auth;
}
