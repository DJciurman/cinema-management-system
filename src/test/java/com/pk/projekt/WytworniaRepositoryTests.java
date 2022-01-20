package com.pk.projekt;

import com.pk.projekt.classes.Wytwornia;
import com.pk.projekt.classes.WytworniaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class WytworniaRepositoryTests {

  @Autowired
  private WytworniaRepository repoWytwornia;

  @Test
  public void testAddWytwornia() {
    Wytwornia wytwornia = new Wytwornia();

    wytwornia.setNazwa("DC Comics");

    repoWytwornia.save(wytwornia);
  }
}
