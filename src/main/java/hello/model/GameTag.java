package hello.model;

import jakarta.persistence.*;

@Entity
@Table(name = "game_tags")
public class GameTag {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_tags_id_gen")
    @SequenceGenerator(name = "game_tags_id_gen", sequenceName = "game_tags_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "game_id", nullable = false)
    private Integer gameId;

    @Column(name = "tag_id", nullable = false)
    private Integer tagId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

}