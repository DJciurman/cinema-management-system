package com.pk.projekt;

import com.pk.projekt.classes.Rodzaj;
import com.pk.projekt.classes.RodzajRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class RodzajRepositoryTests {

  @Autowired
  private RodzajRepository repoRodzaj;

  @Test
  public void testAddRodzaj() {
    Rodzaj rodzaj = new Rodzaj();

    rodzaj.setNazwa("Film");

    repoRodzaj.save(rodzaj);

    rodzaj = new Rodzaj();

    rodzaj.setNazwa("Serial");

    repoRodzaj.save(rodzaj);
  }

}
