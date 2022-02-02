package io.nbaars.superheroes.controller;

import io.nbaars.superheroes.controller.errors.SuperHeroAppError;
import io.nbaars.superheroes.exceptions.NonExistingHeroException;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SuperHeroControllerAdvice {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(SuperHeroControllerAdvice.class);

    @ExceptionHandler(NonExistingHeroException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public SuperHeroAppError handleNonExistingHero(NonExistingHeroException ex) {
        return new SuperHeroAppError(ex.getErrorCode(), "This superhero is hiding in the cave");
    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public SuperHeroAppError handleAllElse(Throwable t) {
        log.error("Something went wrong", t);
        return new SuperHeroAppError("FAILURE", "Does not compute");
    }
}
