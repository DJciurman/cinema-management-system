package com.pk.projekt.order;

import com.pk.projekt.orderSnack.OrderSnack;
import com.pk.projekt.payment.Payment;
import com.pk.projekt.seance.Seance;
import com.pk.projekt.seat.Seat;
import com.pk.projekt.snack.Snack;
import com.pk.projekt.user.User;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "zamowienie")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(length = 11, name = "id")
  private int id;

  @Column(nullable = false, length = 255, name = "opis")
  private String description;

  @ManyToOne
  @JoinColumn(name = "seans_id", nullable = false)
  private Seance seance;

  @OneToOne
  @JoinColumn (name = "platnosc_id", nullable = false)
  private Payment payment;

  @ManyToOne
  @JoinColumn(name = "uzytkownik_id", nullable = false)
  private User user;

  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
  @JoinTable(name = "zamowienie_miejsce",
  joinColumns = {
          @JoinColumn(name = "zamowienie_id", referencedColumnName = "id", nullable = false, updatable = false)},
          inverseJoinColumns = {
          @JoinColumn(name = "miejsce_id", referencedColumnName = "id", nullable = false, updatable = false)}) //literówka?
  private Set<Seat> seat = new HashSet<>();

  @OneToMany(mappedBy = "order", targetEntity = OrderSnack.class, cascade = CascadeType.ALL)
  private Set<OrderSnack> orderSnack;

  @Column(length = 11, name = "kwota", nullable = false)
  private int total;

  @Column(length = 11, name = "data", nullable = false)
  private Date date;

  public int getId() {
    return id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Seance getSeance() {
    return seance;
  }

  public void setSeance(Seance seance) {
    this.seance = seance;
  }

  public Payment getPayment() {
    return payment;
  }

  public void setPayment(Payment payment) {
    this.payment = payment;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Set<Seat> getSeat() {
    return seat;
  }

  public Set<OrderSnack> getOrderSnack() {
    return orderSnack;
  }

  public void setSeat(Set<Seat> seats){
    this.seat = seats;
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }
}
