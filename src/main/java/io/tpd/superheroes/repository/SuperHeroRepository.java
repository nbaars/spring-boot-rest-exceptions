package io.tpd.superheroes.repository;

import io.tpd.superheroes.domain.SuperHero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Provides access to io.tpd.superheroes' data
 * @author moises.macero
 */
public interface SuperHeroRepository extends JpaRepository<SuperHero, Long> {

    <T> Optional<T> findById(Long id, Class<T> clazz);

    Optional<SuperHero> findByHeroName(String firstName);

}
