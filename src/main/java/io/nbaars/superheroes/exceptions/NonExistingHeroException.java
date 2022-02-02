package io.nbaars.superheroes.exceptions;

import io.nbaars.superheroes.controller.errors.ErrorCode;

public class NonExistingHeroException extends RuntimeException implements ErrorCode {

    public NonExistingHeroException(final String message) {
        super(message);
    }

    @Override
    public String getErrorCode() {
        return "NE-001";
    }
}
