package game.review;

import game.review.model.*;
import game.review.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.util.*;


@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner seedDatabase(
            UserRepository userRepository,
            GameRepository gameRepository,
            TagRepository tagRepository,
            ReviewRepository reviewRepository,
            ReviewCategoryRepository reviewCategoryRepository,
            ReviewCategoryScoreRepository reviewCategoryScoreRepository) {
        return args -> {
            userRepository.deleteAll();
            gameRepository.deleteAll();
            tagRepository.deleteAll();
            reviewCategoryRepository.deleteAll();
            reviewRepository.deleteAll();

            // Seed users
            User johnDoe = new User(null, Instant.now(), Instant.now(), "john_doe", "john.doe@example.com", "John", "Doe", "Gamer and reviewer", "profile1.jpg", new HashSet<>());
            User janeDoe = new User(null, Instant.now(), Instant.now(), "jane_doe", "jane.doe@example.com", "Jane", "Doe", "RPG enthusiast", "profile2.jpg", new HashSet<>());
            userRepository.saveAll(Arrays.asList(johnDoe, janeDoe));

            // Seed tags
            Tag action = new Tag(null, "Action", "Action based games", new HashSet<>());
            Tag rpg = new Tag(null, "RPG", "Role-playing games", new HashSet<>());
            tagRepository.saveAll(Arrays.asList(action, rpg));


            // Seed games
            Game eldenRing = new Game(null, Instant.now(), Instant.now(), "Elden Ring", "An action RPG game", "elden_ring.jpg", new HashSet<>(), new HashSet<>());
            Game mario = new Game(null, Instant.now(), Instant.now(), "Mario", "Platforming fun for all ages", "mario.jpg", new HashSet<>(), new HashSet<>());


            eldenRing.addTag(action);
            eldenRing.addTag(rpg);
            mario.addTag(action);
            gameRepository.saveAll(Arrays.asList(eldenRing, mario));

            // Seed review categories
            ReviewCategory story = new ReviewCategory(null, "Story", new HashSet<>());
            ReviewCategory gameplay = new ReviewCategory(null, "Gameplay", new HashSet<>());
            reviewCategoryRepository.saveAll(Arrays.asList(story, gameplay));



            // Seed reviews
            Review review1 = new Review(null, Instant.now(), Instant.now(), johnDoe, eldenRing, new ArrayList<>());
            Review review2 = new Review(null, Instant.now(), Instant.now(), janeDoe, mario, new ArrayList<>());
            reviewRepository.saveAll(Arrays.asList(review1, review2));

            // Add review category scores
            ReviewCategoryScore score1 = new ReviewCategoryScore(null, 9.5f, "Excellent story!", review1, story);
            ReviewCategoryScore score2 = new ReviewCategoryScore(null,  8.0f, "Challenging gameplay.", review1, gameplay);
            ReviewCategoryScore score3 = new ReviewCategoryScore(null, 10.0f, "A masterpiece.", review2, story );
            reviewCategoryScoreRepository.saveAll(Arrays.asList(score1, score2, score3));

            // Add scores to reviews
            review1.getCategoryScores().addAll(Arrays.asList(score1, score2));
            review2.getCategoryScores().add(score3);
            reviewRepository.saveAll(Arrays.asList(review1, review2)); // Save reviews again with updated relationships
        };
    }
}
