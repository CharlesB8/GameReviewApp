package game.review.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "games")
public class Game {
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "games_id_gen")
    @SequenceGenerator(name = "games_id_gen", sequenceName = "games_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;


    @Setter
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private Instant createdAt;

    @Setter
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "updated_at")
    private Instant updatedAt;

    @Setter
    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @Setter
    @Column(name = "description", nullable = false, length = 300)
    private String description;

    @Setter
    @Column(name = "thumbnail_src", length = 1000)
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