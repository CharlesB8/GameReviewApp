package game.review.dto;

import lombok.Getter;
import org.springframework.lang.Nullable;

import java.util.Set;

@Getter
public class ReviewCategoryScoreDTO {
    private float score;
    @Nullable
    private String opinion;
    private Set<GameDTO> games;
}
