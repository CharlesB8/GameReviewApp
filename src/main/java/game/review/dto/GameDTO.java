package game.review.dto;

import game.review.model.Game;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GameDTO {
    private Integer id;
    private String title;
    private String description;
    private String thumbnailSrc;
    private List<TagDTO> tags;
    private List<ReviewDTO> reviews;

    public static GameDTO fromEntity(Game game) {
        return GameDTO.builder()
                .id(game.getId())
                .title(game.getTitle())
                .description(game.getDescription())
                .thumbnailSrc(game.getThumbnailSrc())
                .tags(game.getTags().stream().map(TagDTO::fromEntity).toList())
                .reviews(game.getReviews().stream().map(ReviewDTO::fromEntity).toList())
                .build();
    }
}
