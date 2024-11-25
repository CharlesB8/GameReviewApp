package hello.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "review_categories")
public class ReviewCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "review_categories_id_gen")
    @SequenceGenerator(name = "review_categories_id_gen", sequenceName = "review_categories_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 50)
    private String name;

    @OneToMany(mappedBy = "reviewCategory")
    private Set<ReviewCategoryScore> categoryScores = new HashSet<>();
}