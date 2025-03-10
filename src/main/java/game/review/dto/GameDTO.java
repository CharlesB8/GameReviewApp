package game.review.dto;

import com.fasterxml.jackson.databind.JsonNode;
import game.review.model.Game;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.time.Instant;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GameDTO {
    private Integer id;
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotBlank
    private String thumbnailSrc;
    private List<TagDTO> tags;
    private List<ReviewDTO> reviews;

    public static GameDTO fromEntity(@Valid Game game) {
        return GameDTO.builder()
                .id(game.getId())
                .title(game.getTitle())
                .description(game.getDescription())
                .thumbnailSrc(game.getThumbnailSrc())
//                .tags(game.getTags().stream().map(TagDTO::fromEntity).toList())
//                .reviews(game.getReviews().stream().map(ReviewDTO::fromEntity).toList())
                .build();
    }
}
