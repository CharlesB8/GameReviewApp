package game.review.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reviews")
public class Review {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reviews_id_gen")
    @SequenceGenerator(name = "reviews_id_gen", sequenceName = "reviews_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Setter
    @Getter
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private Instant createdAt;

    @Setter
    @Getter
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "updated_at")
    private Instant updatedAt;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @Getter
    @OneToMany(mappedBy = "review")
    private List<ReviewCategoryScore> categoryScores = new ArrayList<>();
}