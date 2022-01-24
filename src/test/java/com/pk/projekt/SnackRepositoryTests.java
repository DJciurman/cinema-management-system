package com.pk.projekt;

import com.pk.projekt.snack.Snack;
import com.pk.projekt.snack.SnackRepository;
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

    snack.setName("Lejsy");
    snack.setDescription("Kukurydziane trójkąty");
    snack.setPrice(12.00F);
    snack.setAmount(100);
    repoSnack.save(snack);

    snack = new Snack();

    snack.setName("Czipikao");
    snack.setDescription("Kukurydziane trójkąty");
    snack.setPrice(12.00F);
    snack.setAmount(100);
    repoSnack.save(snack);

    snack = new Snack();

    snack.setName("Popkorn");
    snack.setDescription("Kukurydziane trójkąty");
    snack.setPrice(12.00F);
    snack.setAmount(100);
    repoSnack.save(snack);

    snack = new Snack();

    snack.setName("Koka-kola");
    snack.setDescription("Kukurydziane trójkąty");
    snack.setPrice(12.00F);
    snack.setAmount(100);
    repoSnack.save(snack);

    snack = new Snack();

    snack.setName("sewen-ap");
    snack.setDescription("Kukurydziane trójkąty");
    snack.setPrice(12.00F);
    snack.setAmount(100);
    repoSnack.save(snack);
  }
}
