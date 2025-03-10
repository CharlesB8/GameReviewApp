package game.review.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "games_id_gen")
    @SequenceGenerator(name = "games_id_gen", sequenceName = "games_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;


    @NotNull
    private Instant createdAt;

    @NotNull
    private Instant updatedAt;

    @NotNull
    private String title;

    @NotNull
    private String description;

    @NotNull
    private String thumbnailSrc;

    @ManyToMany
    @JoinTable(
            name = "game_tags",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    @JsonManagedReference
    private Set<Tag> tags = new HashSet<>();

    @Setter
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Review> reviews = new HashSet<>();

    public void addTag(Tag tag) {
        this.tags.add(tag);
        tag.getGames().add(this);
    }
}