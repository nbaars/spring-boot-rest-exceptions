package demo.superheroes;

import demo.superheroes.domain.SuperHero;
import demo.superheroes.repository.SuperHeroRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private SuperHeroRepository repository;

    public DataLoader(SuperHeroRepository repository) {
        this.repository = repository;
    }

    public void run(ApplicationArguments args) {
        repository.save(new SuperHero("Peter", "Parker", "Spiderman"));
    }
}