package game.review.controller;

import game.review.model.Game;
import game.review.repository.GameRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static game.review.controller.OpenAPIExampleResponses.LIST_GAMES_DUMMY_RESPONSE;

@Tag(name = "Game Controller", description="Endpoints for games")
@RestController
@RequestMapping("/api/games")
@ApiResponses(
        value = {
                @ApiResponse(
                        responseCode = "200",
                        description = "Successful operation",
                        content = {
                                @Content(
                                        mediaType = "application/json",
                                        examples = {@ExampleObject(value = LIST_GAMES_DUMMY_RESPONSE)})
                        })
        })
public class GameController {

    private final GameRepository gameRepository;

    public GameController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @GetMapping("")
    @Operation(summary = "Get All Games", description = "Get all games including name and genre")
    public List<Game> getGames() {
        return gameRepository.findAll();
    }
}
