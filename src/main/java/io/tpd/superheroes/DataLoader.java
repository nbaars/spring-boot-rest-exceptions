package io.tpd.superheroes;

import io.tpd.superheroes.domain.SuperHero;
import io.tpd.superheroes.repository.SuperHeroRepository;
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
        repository.save(new SuperHero("lala", "lala", "lala"));
    }
}