package hello.controller;

import hello.model.ExampleEntity;
import hello.service.ExampleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExampleController {
    private final ExampleService service;

    public ExampleController(ExampleService service) {
        this.service = service;
    }

    @GetMapping("/hello")
    public List<ExampleEntity> sayHello() {
        return service.getAllEntities();
    }
}
