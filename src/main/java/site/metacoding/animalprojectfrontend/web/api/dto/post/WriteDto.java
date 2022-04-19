package site.metacoding.animalprojectfrontend.web.api.dto.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.animalprojectfrontend.config.post.Post;
import site.metacoding.animalprojectfrontend.domain.user.User;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class WriteDto {
    private String title;
    private String content;
    private String board;
    private String region;
    private String type;
    private String category;

    public Post toEntity(User principal) {
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setBoard(board);
        post.setRegion(region);
        post.setType(type);
        post.setCategory(category);
        post.setUser(principal);
        return post;
    }
}
