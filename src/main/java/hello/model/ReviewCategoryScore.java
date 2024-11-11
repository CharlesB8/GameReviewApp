package hello.model;

import jakarta.persistence.*;

@Entity
@Table(name = "review_category_scores")
public class ReviewCategoryScore {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "review_category_scores_id_gen")
    @SequenceGenerator(name = "review_category_scores_id_gen", sequenceName = "review_category_score_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "review_category_id", nullable = false)
    private Integer reviewCategoryId;

    @Column(name = "review_id", nullable = false)
    private Integer reviewId;

    @Column(name = "score", nullable = false)
    private Float score;

    @Column(name = "opinion", length = 500)
    private String opinion;

    @ManyToOne
    @JoinColumn(name = "review_id")
    private Review review;

    @ManyToOne
    @JoinColumn(name = "review_category_id")
    private ReviewCategory reviewCategory;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReviewCategoryId() {
        return reviewCategoryId;
    }

    public void setReviewCategoryId(Integer reviewCategoryId) {
        this.reviewCategoryId = reviewCategoryId;
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

}