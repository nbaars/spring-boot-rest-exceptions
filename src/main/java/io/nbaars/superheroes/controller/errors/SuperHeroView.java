package io.nbaars.superheroes.controller.errors;

import org.springframework.beans.factory.annotation.Value;

public interface SuperHeroView {

    @Value("#{target.firstName}") // <-- If you remove this it will work
    String getFirstNames();
    String getTest(); // <-- Not a valid property
}
