package com.pk.projekt;

import com.pk.projekt.order.Order;
import com.pk.projekt.order.OrderRepository;
import com.pk.projekt.orderSnack.OrderSnack;
import com.pk.projekt.orderSnack.OrderSnackRepository;
import com.pk.projekt.snack.Snack;
import com.pk.projekt.snack.SnackRepository;
import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class OrderSnackRepositoryTests {

  @Autowired
  private OrderRepository repoOrder;

  @Autowired
  private SnackRepository repoSnack;

  @Autowired
  private OrderSnackRepository repoOrderSnack;

  @Test
  public void testAddOrderSnack() {
    Snack snack = repoSnack.findSnackById(1);
    Order order = repoOrder.findOrderById(1);

    OrderSnack orderSnack = new OrderSnack();

    orderSnack.setSnack(snack);
    orderSnack.setOrder(order);

    repoOrderSnack.save(orderSnack);

  }
}
