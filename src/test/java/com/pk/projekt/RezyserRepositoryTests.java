package com.pk.projekt;


import com.pk.projekt.classes.Rezyser;
import com.pk.projekt.classes.RezyserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class RezyserRepositoryTests {

  @Autowired
  private RezyserRepository repoRezyser;

  @Test
  public void testAddRezyser() {
    Rezyser rezyser = new Rezyser();

    rezyser.setImie("Andreas");
    rezyser.setNazwisko("Muschietti");

    repoRezyser.save(rezyser);

  }
}
