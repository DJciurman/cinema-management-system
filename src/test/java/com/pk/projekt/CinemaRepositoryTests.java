package com.pk.projekt;

import com.pk.projekt.cinema.Cinema;
import com.pk.projekt.cinema.CinemaRepository;
import com.pk.projekt.snack.Snack;
import com.pk.projekt.snack.SnackRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.annotation.Rollback;

import java.util.HashSet;
import java.util.Set;

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

    Set<Snack> snacks = new HashSet<>();
    Snack snack = repoSnack.findSnackById(2);
    Snack snack1 = repoSnack.findSnackById(3);
    Snack snack2 = repoSnack.findSnackById(4);
    Snack snack3 = repoSnack.findSnackById(5);

    snacks.add(snack);
    snacks.add(snack1);
    snacks.add(snack2);
    snacks.add(snack3);

    cinema.getSnack().addAll(snacks);

    repoCinema.save(cinema);
  }
}
