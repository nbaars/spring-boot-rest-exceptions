package io.nbaars.superheroes.repository;

import io.nbaars.superheroes.domain.SuperHero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SuperHeroRepository extends JpaRepository<SuperHero, Long> {

    <T> Optional<T> findById(Long id, Class<T> clazz);

    Optional<SuperHero> findByHeroName(String firstName);

}
