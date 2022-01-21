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
public class OrderRepositoryTests {

  @Autowired
  private OrderRepository repoOrder;

  @Autowired
  private SeanceRepository repoSeance;

  @Autowired
  private PaymentRepository repoPayment;

  @Autowired
  private UserRepository repoUser;

  @Autowired
  private SnackRepository repoSnack;

  @Autowired
  private SeatRepository repoSeat;

  @Test
  public void testAddOrder() {
    Order order = new Order();

    Seance seance = repoSeance.findSeanceById(1);
    Payment payment = repoPayment.findPaymentById(1);
    User user = repoUser.findUserById(1);
    Snack snack = repoSnack.findSnackById(1);
    Seat seat = repoSeat.findSeatByRowAndColumn(1, 1);

    order.setDescription("Zamówienie z jedzeniem");
    order.setSeance(seance);
    order.setPayment(payment);
    order.setUser(user);
    order.getSnack().add(snack);
    order.getSeat().add(seat);

    repoOrder.save(order);
  }
}
