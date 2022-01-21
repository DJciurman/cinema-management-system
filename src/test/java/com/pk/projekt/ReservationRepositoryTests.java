package com.pk.projekt;

import com.pk.projekt.classes.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ReservationRepositoryTests {

  @Autowired
  private ReservationRepository repoReservation;

  @Autowired
  private UserRepository repoUser;

  @Autowired
  private SeanceRepository repoSeance;

  @Test
  public void testAddReservation() {
    Reservation reservation = new Reservation();

    reservation.setDescription("Opis rezerwacji");

    Seance seance = repoSeance.findSeanceById(1);
    User user = repoUser.findUserById(1);

    reservation.setSeance(seance);
    reservation.setUser(user);

    repoReservation.save(reservation);


  }
}
