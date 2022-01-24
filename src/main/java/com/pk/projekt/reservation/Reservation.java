package com.pk.projekt.reservation;

import com.pk.projekt.seance.Seance;
import com.pk.projekt.seat.Seat;
import com.pk.projekt.user.User;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "rezerwacja")
public class Reservation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(length = 11, name = "id")
  private int id;

  @Column(nullable = false, length = 255, name = "opis")
  private String description;

  @ManyToOne
  @JoinColumn(name = "seans_id", nullable = false)
  private Seance seance;

  @ManyToOne
  @JoinColumn(name = "uzytkownik_id", nullable = false)
  private User user;

  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
  @JoinTable(name = "rezerwacja_miejsce",
          joinColumns = {
                  @JoinColumn(name = "rezerwacja_id", referencedColumnName = "id", nullable = false, updatable = false)},
          inverseJoinColumns = {
                  @JoinColumn(name = "miejsce_id", referencedColumnName = "id", nullable = false, updatable = false)}) //literówka?
  private Set<Seat> seat = new HashSet<>();

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

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Set<Seat> getSeat() {
    return seat;
  }
}
