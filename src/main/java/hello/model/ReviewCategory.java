package hello.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

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
    private List<ReviewCategory> categoryScores = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}