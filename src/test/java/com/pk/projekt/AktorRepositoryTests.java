package com.pk.projekt;


import com.pk.projekt.classes.Aktor;
import com.pk.projekt.classes.AktorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class AktorRepositoryTests {

  @Autowired
  private AktorRepository repoAktor;

  @Test
  public void testAddAktor() {
    Aktor aktor = new Aktor();

    aktor.setImie("Tom");
    aktor.setNazwisko("Cavanagh");

    repoAktor.save(aktor);
  }
}
