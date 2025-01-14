package game.review.dto;

import game.review.model.Game;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class ReviewDTO {
    private Integer id;
    private Instant createdAt;
    private Instant updatedAt;
    private Integer userId;
    private UserDTO user;
    private Integer gameId;
    private Game game;
    private Set<ReviewCategoryScoreDTO> categoryScores;
}
