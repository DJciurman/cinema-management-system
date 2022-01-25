package com.pk.projekt.payment;

import com.pk.projekt.order.Order;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "platnosc")
public class Payment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(length = 11, name = "id")
  private int id;

  @Column(nullable = false, length = 255, name = "typ")
  private String type;

  @Column(nullable = false, length = 255, name = "stan")
  private String state;

  @OneToOne(mappedBy = "payment", targetEntity = Order.class, cascade = CascadeType.ALL)
  private Order order;

  public int getId() {
    return id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public Order getOrder() {
    return order;
  }

  public void setOrder(Order order) {
    this.order = order;
  }
}
