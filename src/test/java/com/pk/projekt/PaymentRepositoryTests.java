package com.pk.projekt;

import com.pk.projekt.classes.payment.Payment;
import com.pk.projekt.classes.payment.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class PaymentRepositoryTests {

  @Autowired
  private PaymentRepository repoPayment;

  @Test
  public void testAddPayment() {
    Payment payment = new Payment();

    payment.setType("Przelew");
    payment.setState("Płatność została otrzymana");

    repoPayment.save(payment);
  }

}
