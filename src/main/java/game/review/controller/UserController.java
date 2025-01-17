package game.review.controller;

import game.review.dto.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static game.review.controller.OpenAPIExampleResponses.GET_USER_DUMMY_RESPONSE;
import static game.review.controller.OpenAPIExampleResponses.UPDATE_USER_DUMMY_RESPONSE;

@Tag(name = "User Controller", description="Endpoints for user")
@RestController
@RequestMapping("/api/user")
public class UserController {

    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successful operation",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            examples = {@ExampleObject(value = GET_USER_DUMMY_RESPONSE)})
                            })
            })
    @GetMapping("/{userId}")
    @Operation(summary = "Get User", description = "Get a specific user")
    public ResponseEntity<UserDTO> get(@Parameter(description = "User Id") @PathVariable String userId) {
        return ResponseEntity.ok(new UserDTO());
    }

    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successful operation",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            examples = {@ExampleObject(value = UPDATE_USER_DUMMY_RESPONSE)})
                            })
            })
    @PutMapping("/{userId}")
    @Operation(summary = "Update User", description = "Update a specific user")
    public ResponseEntity<UserDTO> update(@Parameter(description = "User Id") @PathVariable String userId, UserDTO userDTO) {
        return ResponseEntity.ok(new UserDTO());
    }
}
