package hello.service;

import hello.model.ExampleEntity;
import hello.repository.ExampleEntityRepository;
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
