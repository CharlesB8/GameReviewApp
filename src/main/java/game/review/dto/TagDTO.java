package game.review.dto;

import lombok.Getter;

import java.util.Set;

@Getter
public class TagDTO {
    private String name;
    private String description;
    private Set<GameDTO> games;
    private Set<TagDTO> tags;
}
