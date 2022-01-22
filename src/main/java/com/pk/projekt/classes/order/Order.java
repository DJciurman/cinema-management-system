package com.pk.projekt.classes.order;

import com.pk.projekt.classes.payment.Payment;
import com.pk.projekt.classes.seance.Seance;
import com.pk.projekt.classes.seat.Seat;
import com.pk.projekt.classes.snack.Snack;
import com.pk.projekt.classes.user.User;

import javax.persistence.*;
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
          @JoinColumn(name = "miejse_rzad", referencedColumnName = "rzad", nullable = false, updatable = false),
                  @JoinColumn(name = "miejsce_kolumna", referencedColumnName = "kolumna", nullable = false, updatable = false)})
  private Set<Seat> seat = new HashSet<>();

  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
  @JoinTable(name = "przekaska_zamowienie",
  joinColumns = {
          @JoinColumn(name = "zamowienie_id", referencedColumnName = "id", nullable = false, updatable = false)},
          inverseJoinColumns = {
          @JoinColumn(name = "przekaska_id", referencedColumnName = "id", nullable = false, updatable = false)})
  private Set<Snack> snack = new HashSet<>();

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

  public Set<Snack> getSnack() {
    return snack;
  }

}
