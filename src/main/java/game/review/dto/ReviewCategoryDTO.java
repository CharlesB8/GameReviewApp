package game.review.dto;

import lombok.Getter;
import java.util.Set;

@Getter
public class ReviewCategoryDTO {
    private int id;
    private String name;
    private Set<ReviewCategoryScoreDTO> categoryScores;
}
