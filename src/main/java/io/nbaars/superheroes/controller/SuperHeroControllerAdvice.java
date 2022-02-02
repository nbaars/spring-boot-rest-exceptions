package io.nbaars.superheroes.controller;

import io.nbaars.superheroes.controller.errors.SuperHeroAppError;
import io.nbaars.superheroes.exceptions.NonExistingHeroException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SuperHeroControllerAdvice {

    @ExceptionHandler(NonExistingHeroException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public SuperHeroAppError handleNonExistingHero(NonExistingHeroException ex) {
        return new SuperHeroAppError(ex.getErrorCode(), "This superhero is hiding in the cave");
    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public SuperHeroAppError handleAllElse(Throwable t) {
        return new SuperHeroAppError("FAILURE", "Does not compute");
    }
}
