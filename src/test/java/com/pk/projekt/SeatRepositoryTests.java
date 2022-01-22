package com.pk.projekt;

import com.pk.projekt.classes.seat.Seat;
import com.pk.projekt.classes.seat.SeatRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class SeatRepositoryTests {

  @Autowired
  private SeatRepository repoSeat;

  @Test
  public void testAddSeat() {
    Seat seat = new Seat();

    seat.setRow(1);
    seat.setColumn(1);

    repoSeat.save(seat);
  }


}
