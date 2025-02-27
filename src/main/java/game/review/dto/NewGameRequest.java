package game.review.dto;

public record NewGameRequest(
        String title,
        String description,
        String logoUrl
) {}
