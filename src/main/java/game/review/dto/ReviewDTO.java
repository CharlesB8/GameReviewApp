package game.review.dto;

import game.review.model.Game;
import game.review.model.Review;
import game.review.model.ReviewCategoryScore;
import lombok.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewDTO {
    private Integer id;
    private Instant createdAt;
    private Instant updatedAt;
    private Integer userId;
    private UserDTO user;
    private Integer gameId;
    private List<ReviewCategoryScoreDTO> categoryScores;

    public static ReviewDTO fromEntity(Review review) {
        return ReviewDTO.builder()
                .id(review.getId())
                .createdAt(review.getCreatedAt())
                .updatedAt(review.getUpdatedAt())
                .userId(review.getUser().getId())
                .gameId(review.getGame().getId())
                .categoryScores(review.getCategoryScores().stream().map(ReviewCategoryScoreDTO::fromEntity).toList())
                .build();
    }
}
