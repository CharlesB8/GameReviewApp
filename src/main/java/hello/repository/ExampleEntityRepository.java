package hello.repository;

import hello.model.ExampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExampleEntityRepository extends JpaRepository<ExampleEntity, Long> {
}
