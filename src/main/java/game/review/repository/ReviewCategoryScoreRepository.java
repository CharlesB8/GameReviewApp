package game.review.repository;

import game.review.model.ReviewCategoryScore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewCategoryScoreRepository extends JpaRepository<ReviewCategoryScore, Integer> {
}