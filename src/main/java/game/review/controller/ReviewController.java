package game.review.controller;

import game.review.dto.ReviewDTO;
import game.review.dto.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static game.review.controller.OpenAPIExampleResponses.REVIEW_DUMMY_RESPONSE;
import static game.review.controller.OpenAPIExampleResponses.UPDATE_USER_DUMMY_RESPONSE;

@Tag(name = "Review Controller", description="Endpoints Reviews")
@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successful operation",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            examples = {@ExampleObject(value = REVIEW_DUMMY_RESPONSE)})
                            })
            })
    @Operation(summary = "Create a review", description = "Create a review under a user")
    @PostMapping("/{game_id}/{user_id}/new")
    public ResponseEntity<ReviewDTO> create(
            @Parameter(description = "game id") @PathVariable Long game_id,
            @Parameter(description = "user id") @PathVariable Long user_id
    ) {
        return ResponseEntity.ok(new ReviewDTO());
    }
}
