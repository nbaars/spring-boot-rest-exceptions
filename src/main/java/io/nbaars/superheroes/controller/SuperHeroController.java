package io.nbaars.superheroes.controller;

import io.nbaars.superheroes.controller.errors.SuperHeroView;
import io.nbaars.superheroes.domain.SuperHero;
import io.nbaars.superheroes.exceptions.NonExistingHeroException;
import io.nbaars.superheroes.repository.SuperHeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/superheroes")
public final class SuperHeroController {

    private final SuperHeroRepository superHeroRepository;

    @Autowired
    public SuperHeroController(SuperHeroRepository superHeroRepository) {
        this.superHeroRepository = superHeroRepository;
    }

    @GetMapping("/{id}")
    public SuperHeroView getSuperHeroById(@PathVariable Long id) {
        return superHeroRepository.findById(id, SuperHeroView.class).orElseThrow(() -> new NonExistingHeroException("test"));
    }

    @GetMapping
    public Optional<SuperHero> getSuperHeroByHeroName(@RequestParam("name") String heroName) {
        return superHeroRepository.findByHeroName(heroName);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewSuperHero(@RequestBody @Valid SuperHero superHero) {
        superHeroRepository.save(superHero);
    }

}
