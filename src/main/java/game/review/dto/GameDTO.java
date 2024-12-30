package game.review.dto;

import java.util.Set;

public record GameDTO(
        Integer id,
        String title,
        String description,
        String thumbnailSrc,
        Set<TagDTO> tags,
        Set<ReviewDTO> reviews
) {}
