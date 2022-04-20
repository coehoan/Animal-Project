package site.metacoding.animalprojectfrontend.web.api.dto.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.animalprojectfrontend.domain.post.Post;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RecReqDto {
    private Integer id;
    private Integer recommended;

    public Post toEntity() {
        Post post = new Post();
        post.setId(id);
        post.setRecommended(recommended);
        return post;
    }
}
