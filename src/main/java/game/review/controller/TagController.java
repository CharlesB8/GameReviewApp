package game.review.controller;

import game.review.dto.TagDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static game.review.controller.OpenAPIExampleResponses.REVIEW_DUMMY_RESPONSE;
import static game.review.controller.OpenAPIExampleResponses.TAG_DUMMY_RESPONSE;

@Tag(name = "Tag Controller", description="Endpoints Tag")
@RestController
@RequestMapping("/api/tags")
public class TagController {

    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successful operation",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            examples = {@ExampleObject(value = TAG_DUMMY_RESPONSE)})
                            })
            })
    @Operation(summary = "Get all tags")
    @GetMapping("")
    public ResponseEntity<TagDTO> list() {
        return ResponseEntity.ok(new TagDTO());
    }

    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successful operation",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            examples = {@ExampleObject(value = TAG_DUMMY_RESPONSE)})
                            })
            })
    @Operation(summary = "Create tag")
    @GetMapping("/new")
    public ResponseEntity<TagDTO> create(String name, String description) {
       return ResponseEntity.ok(new TagDTO());
    }

}
