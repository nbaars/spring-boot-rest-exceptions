package io.tpd.superheroes.controller.errors;

import org.springframework.beans.factory.annotation.Value;

public interface SuperHeroView {

    @Value("#{target.firstName}")
    String getFirstNames();
    String getTest(); // <-- Not a valid property
}
