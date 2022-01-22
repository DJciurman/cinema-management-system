package com.pk.projekt.snack;

import com.pk.projekt.cinema.Cinema;
import com.pk.projekt.order.Order;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "przekaska")
public class Snack {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(length = 11, name = "id")
  private int id;

  @Column(length = 255, name = "nazwa")
  private String name;

  @Column(nullable = false, length = 255, name = "opis")
  private String description;

  @Column(nullable = false, precision = 2, scale = 2, name = "cena")
  private Float price;

  @Column(nullable = false, length = 11, name = "ilosc")
  private int amount;

  @ManyToMany(mappedBy = "snack", targetEntity = Cinema.class, cascade = CascadeType.ALL)
  private Set<Cinema> cinema;

  @ManyToMany(mappedBy = "snack", targetEntity = Order.class, cascade = CascadeType.ALL)
  private Set<Order> order;

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Float getPrice() {
    return price;
  }

  public void setPrice(Float price) {
    this.price = price;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public Set<Cinema> getCinema() {
    return cinema;
  }

  public Set<Order> getOrder() {
    return order;
  }

}
