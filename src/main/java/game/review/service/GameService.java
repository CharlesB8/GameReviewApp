package game.review.service;

import com.fasterxml.jackson.databind.JsonNode;
import game.review.dto.GameDTO;
import game.review.dto.NewGameRequest;
import game.review.model.Game;
import game.review.repository.GameRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class GameService {
    private final GameRepository gameRepository;

    public GameDTO createGame(NewGameRequest postBody) {
        return GameDTO.fromEntity(gameFromRequest(postBody));
    }

    private Game gameFromRequest(NewGameRequest postBody) {
        Game game = Game.builder()
                .title(postBody.title())
                .description(postBody.description())
                .thumbnailSrc(postBody.logoUrl())
                .build();

        gameRepository.save(game);

        return game;
    }
}
