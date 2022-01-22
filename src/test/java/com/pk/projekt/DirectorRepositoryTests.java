package com.pk.projekt;


import com.pk.projekt.classes.director.Director;
import com.pk.projekt.classes.director.DirectorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class DirectorRepositoryTests {

  @Autowired
  private DirectorRepository repoDirector;

  @Test
  public void testAddDirector() {
    Director director = new Director();

    director.setFirstName("Andreas");
    director.setLastName("Muschietti");

    repoDirector.save(director);

  }
}
