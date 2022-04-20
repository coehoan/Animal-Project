package site.metacoding.animalprojectfrontend.web.api.dto.animals;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostRegionDto {
    
    private String sido;
    private String sigungu;

    public PostRegionDto toEntity(PostRegionDto keywordOfSido) {
        PostRegionDto region = PostRegionDto.builder()
        .sido(this.sido)
        .build();

        return region;
    }

}
