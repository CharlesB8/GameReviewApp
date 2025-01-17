package game.review.controller;

import game.review.dto.GameDTO;
import game.review.model.Game;
import game.review.repository.GameRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static game.review.controller.OpenAPIExampleResponses.*;

@Tag(name = "Game Controller", description="Endpoints for games")
@RestController
@RequestMapping("/api/games")
public class GameController {
    private final GameRepository gameRepository;

    public GameController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @GetMapping("")
    @Operation(summary = "Get All Games", description = "Get all games including name and genre")
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
    public List<Game> list() {
        return gameRepository.findAll();
    }

    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successful operation",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            examples = {@ExampleObject(value = GAME_DUMMY_RESPONSE)})
                            })
            })
    @GetMapping("/{gameId}")
    @Operation(summary = "Get game", description = "Get game by game id")
    public ResponseEntity<GameDTO> get(@Parameter(description = "Game Id") @PathVariable String gameId) {
        return ResponseEntity.ok(new GameDTO());
    }

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
    @GetMapping("/search/{query}")
    @Operation(summary = "Get games by query", description = "User a query search for games")
    public ResponseEntity<List<GameDTO>> listByQuery(@Parameter(description = "Query string") @PathVariable String query) {
        return ResponseEntity.ok(new ArrayList<>());
    }

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
    @GetMapping("user/{userId}")
    @Operation(summary = "Get games reviewed by user", description = "Get all games reviewed by a user")
    public ResponseEntity<List<GameDTO>> listReviewedByUser(@Parameter(description = "User Id") @PathVariable String userId) {
        return ResponseEntity.ok(new ArrayList<>());
    }

    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successful operation",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            examples = {@ExampleObject(value = GAME_DUMMY_RESPONSE)})
                            })
            })
    @PutMapping("/{gameId}")
    @Operation(summary = "Update Game", description = "Update the given game")
    public ResponseEntity<GameDTO> update(@Parameter(description = "Game ID") @PathVariable String gameId) {
        return ResponseEntity.ok(new GameDTO());
    }
}
