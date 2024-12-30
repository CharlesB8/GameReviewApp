package game.review.dto;

import lombok.Getter;
import org.springframework.lang.Nullable;

import java.util.Set;

@Getter
public class GameDTO {
    private Integer id;
    private String title;
    private String description;
    @Nullable
    private String thumbnailSrc;
    private Set<TagDTO> tags;
    private Set<ReviewDTO> review;
}
