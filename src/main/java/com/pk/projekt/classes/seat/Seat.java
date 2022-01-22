package com.pk.projekt.classes.seat;

import com.pk.projekt.classes.order.Order;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "miejsce")
@IdClass(SeatId.class)
public class Seat {

  @Id
  @Column(nullable = false, length = 11, name = "rzad")
  private int row;

  @Id
  @Column(nullable = false, length = 11, name = "kolumna")
  private int column;

  @ManyToMany(mappedBy = "seat", targetEntity = Order.class, cascade = CascadeType.ALL)
  private Set<Order> order;

  public int getRow() {
    return row;
  }

  public void setRow(int row) {
    this.row = row;
  }

  public int getColumn() {
    return column;
  }

  public void setColumn(int column) {
    this.column = column;
  }

  public Set<Order> getOrder() {
    return order;
  }

}
