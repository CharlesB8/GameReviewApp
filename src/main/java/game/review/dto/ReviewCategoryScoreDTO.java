package game.review.dto;

import game.review.model.ReviewCategoryScore;
import lombok.Builder;
import lombok.Getter;
import org.springframework.lang.Nullable;

import java.util.Set;

@Getter
@Builder
public class ReviewCategoryScoreDTO {
    private Float score;
    private String opinion;

    public static ReviewCategoryScoreDTO fromEntity(ReviewCategoryScore reviewCategoryScore) {
        return ReviewCategoryScoreDTO.builder()
                .score(reviewCategoryScore.getScore())
                .opinion(reviewCategoryScore.getOpinion())
                .build();
    }
}
