package com.pk.projekt.seat;

import com.pk.projekt.order.Order;
import com.pk.projekt.reservation.Reservation;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "miejsce")
public class Seat {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(length = 11, name = "id")
  private int id;

  @Column(nullable = false, length = 11, name = "rzad")
  private int row;

  @Column(nullable = false, length = 11, name = "kolumna")
  private int column;

  @ManyToMany(mappedBy = "seat", targetEntity = Order.class, cascade = CascadeType.ALL)
  private Set<Order> order;

  @ManyToMany(mappedBy = "seat", targetEntity = Reservation.class, cascade = CascadeType.ALL)
  private Set<Reservation> reservation;

  public Seat(Integer number){
    this.row = number;
  }

  public Seat(){}

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

  public int getId() {
    return id;
  }

  public Set<Reservation> getReservation() {
    return reservation;
  }
}
