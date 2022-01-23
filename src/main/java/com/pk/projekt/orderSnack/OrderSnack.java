package com.pk.projekt.orderSnack;

import com.pk.projekt.order.Order;
import com.pk.projekt.snack.Snack;

import javax.persistence.*;

@Entity
@Table(name = "przekaska_zamowienie")
public class OrderSnack {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(length = 11, name = "id")
  private int id;

  @ManyToOne
  @JoinColumn(name = "zamowienie_id", nullable = false)
  private Order order;

  @ManyToOne
  @JoinColumn(name = "przekaska_id", nullable = false)
  private Snack snack;

  @Column(length = 11, name = "ilosc")
  private int amount;

  public Order getOrder() {
    return order;
  }

  public void setOrder(Order order) {
    this.order = order;
  }

  public Snack getSnack() {
    return snack;
  }

  public void setSnack(Snack snack) {
    this.snack = snack;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public int getId() {
    return id;
  }
}
