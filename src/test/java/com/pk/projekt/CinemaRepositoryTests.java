package com.pk.projekt;

import com.pk.projekt.classes.cinema.Cinema;
import com.pk.projekt.classes.cinema.CinemaRepository;
import com.pk.projekt.classes.snack.Snack;
import com.pk.projekt.classes.snack.SnackRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class CinemaRepositoryTests {

  @Autowired
  private CinemaRepository repoCinema;

  @Autowired
  private SnackRepository repoSnack;

  @Test
  public void testAddCinema() {
    Cinema cinema = new Cinema();

    cinema.setAddress("Warszawska 274");
    cinema.setCity("Kraków");
    cinema.setRoomNumber(10);

    repoCinema.save(cinema);
  }

  @Test
  public void testModifyCinema() {
    Cinema cinema = repoCinema.findCinemaById(1);

    Snack snack = repoSnack.findSnackById(1);

    cinema.getSnack().add(snack);

    repoCinema.save(cinema);
  }
}
