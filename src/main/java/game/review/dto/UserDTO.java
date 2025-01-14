package game.review.dto;

import org.springframework.lang.Nullable;
import lombok.Getter;

@Getter
public class UserDTO {
    private String username;
    private String email;
    @Nullable
    private String firstName;
    @Nullable
    private String lastName;
    @Nullable
    private String bio;
    @Nullable
    private String thumbnailSrc;
}

//@Getter
//public class UserWithGamesDTO {
//
//}
