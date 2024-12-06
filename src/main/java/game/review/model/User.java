package game.review.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_gen")
    @SequenceGenerator(name = "users_id_gen", sequenceName = "users_id_seq", allocationSize = 1)
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
    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Setter
    @Getter
    @Column(name = "email", nullable = false)
    private String email;

    @Setter
    @Getter
    @Column(name = "first_name", length = 50)
    private String firstName;

    @Setter
    @Getter
    @Column(name = "last_name", length = 50)
    private String lastName;

    @Setter
    @Getter
    @Column(name = "bio", length = 300)
    private String bio;

    @Setter
    @Getter
    @Column(name = "thumbnail_src", length = 1000)
    private String thumbnailSrc;

    @OneToMany(mappedBy = "user")
    private Set<Review> reviews = new HashSet<>();
}