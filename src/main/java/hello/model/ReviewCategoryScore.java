package hello.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "review_category_scores")
public class ReviewCategoryScore {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "review_category_scores_id_gen")
    @SequenceGenerator(name = "review_category_scores_id_gen", sequenceName = "review_category_score_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Setter
    @Getter
    @Column(name = "review_category_id", nullable = false, updatable = false, insertable = false)
    private Integer reviewCategoryId;

    @Setter
    @Getter
    @Column(name = "review_id", nullable = false, updatable = false, insertable = false)
    private Integer reviewId;

    @Setter
    @Getter
    @Column(name = "score", nullable = false)
    private Float score;

    @Setter
    @Getter
    @Column(name = "opinion", length = 500)
    private String opinion;

    @ManyToOne
    @JoinColumn(name = "review_id")
    private Review review;

    @ManyToOne
    @JoinColumn(name = "review_category_id")
    private ReviewCategory reviewCategory;
}