package com.pk.projekt;

import com.pk.projekt.classes.Snack;
import com.pk.projekt.classes.SnackRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class SnackRepositoryTests {

  @Autowired
  private SnackRepository repoSnack;

  @Test
  public void testAddSnack() {
    Snack snack = new Snack();

    snack.setName("Naczosy");
    snack.setDescription("Kukurydziane trójkąty");
    snack.setPrice(12.00F);
    snack.setAmount(100);

    repoSnack.save(snack);
  }
}
