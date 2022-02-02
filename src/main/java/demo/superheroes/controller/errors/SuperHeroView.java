package demo.superheroes.controller.errors;

import org.springframework.beans.factory.annotation.Value;

public interface SuperHeroView {

    @Value("#{target.firstName} - #{target.lastName} - alias #{target.heroName}") // <-- If you remove this it will work
    String getName();
    String getLastName();
    String getFirstName();
    String getHeroName();
    String getTest(); // <-- Not a valid property
}
