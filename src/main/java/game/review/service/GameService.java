package game.review.service;

import game.review.dto.NewGameRequest;
import game.review.model.Game;
import game.review.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GameService {
    private final GameRepository gameRepository;

    public Optional<Game> findById(String gameId) {
        return gameRepository.findById(Integer.valueOf(gameId));
    }

    public Game createGame(NewGameRequest postBody) {
        return gameRepository.save(Game.builder()
                        .title(postBody.getTitle())
                        .createdAt(Instant.now())
                        .updatedAt(Instant.now())
                        .description(postBody.getDescription())
                        .thumbnailSrc(postBody.getLogoUrl())
                        .build()
        );
    }
}
