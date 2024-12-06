package game.review.service;

import game.review.model.ExampleEntity;
import game.review.repository.ExampleEntityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExampleService {
    private final ExampleEntityRepository repository;

    public ExampleService(ExampleEntityRepository repository) {
        this.repository = repository;
    }

    public List<ExampleEntity> getAllEntities() {
        return repository.findAll();
    }
}
