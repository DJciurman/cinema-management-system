package com.pk.projekt;

import com.pk.projekt.genre.Genre;
import com.pk.projekt.genre.GenreRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class GenreRepositoryTests {

  @Autowired
  private GenreRepository repoGenre;

  @Test
  public void testAddGenre() {
    Genre genre = new Genre();

    genre.setName("Film");

    repoGenre.save(genre);

    genre = new Genre();

    genre.setName("Serial");

    repoGenre.save(genre);
  }

}
