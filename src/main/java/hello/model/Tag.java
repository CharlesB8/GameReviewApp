package hello.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tags")
public class Tag {
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tags_id_gen")
    @SequenceGenerator(name = "tags_id_gen", sequenceName = "tags_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Setter
    @Column(name = "name", length = 20, unique = true, nullable = false)
    private String name;

    @Setter
    @Column(name = "description", length = 300)
    private String description;


    @ManyToMany(mappedBy = "tags")
//    @JoinTable(
//            name = "game_tags",
//            joinColumns = @JoinColumn(name = "tag_id"),
//            inverseJoinColumns = @JoinColumn(name = "game_id")
//    )
    private Set<Game> games = new HashSet<>();

//    // Ensure bidirectional update of tags and games
//    public void addGame(Game game) {
//        this.games.add(game);
//        game.getTags().add(this);
//    }
//
//    public void removeGame(Game game) {
//        this.games.remove(game);
//        game.getTags().remove(this);
//    }
}