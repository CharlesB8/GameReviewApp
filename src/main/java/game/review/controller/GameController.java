package game.review.controller;

import game.review.dto.GameDTO;
import game.review.dto.NewGameRequest;
import game.review.model.Game;
import game.review.repository.GameRepository;
import game.review.service.GameService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static game.review.controller.OpenAPIExampleResponses.*;

@Tag(name = "Game Controller", description="Endpoints for games")
@RestController
@RequestMapping("/api/games")
@AllArgsConstructor
public class GameController {
    private final GameRepository gameRepository;
    private final GameService gameService;


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
    public ResponseEntity<List<GameDTO>> list() {
        List<Game> games = gameRepository.findAll();
        List<GameDTO> gameDTOS = games.stream().map(GameDTO::fromEntity).toList();

        return ResponseEntity.ok(gameDTOS);
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
        return gameService
                .findById(gameId)
                .map(game -> ResponseEntity.ok(GameDTO.fromEntity(game)))
                .orElse(ResponseEntity.notFound().build());
    }

//    Refactor to use url parameter
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
    @Operation(summary = "Get games reviewed by user", description = "Get all games reviewed by a user")
    public ResponseEntity<GameDTO> update(@Parameter(description = "Game ID") @PathVariable String gameId) {
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
                                            examples = {@ExampleObject(value = GAME_DUMMY_RESPONSE)})
                            })
            })
    @PostMapping(value = "/new", consumes = "application/json")
    @Operation(summary = "Create a Game")
    public ResponseEntity<GameDTO> create(@Validated @RequestBody NewGameRequest body) {
        Game game = gameService.createGame(body);

        return ResponseEntity.ok(GameDTO.fromEntity(game));
    }
}