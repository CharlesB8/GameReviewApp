package hello;

import hello.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ReviewCategoryRepository reviewCategoryRepository;

    @Autowired
    private ReviewCategoryScoreRepository reviewCategoryScoreRepository;

    @Override
    public void run(String... args) throws Exception {
        seedData();
    }

    private void seedData() {
        // Check if data already exists to avoid duplication
        if (userRepository.count() == 0) {
            // Add seeding logic here
        }
    }
}
