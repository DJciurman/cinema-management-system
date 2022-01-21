package com.pk.projekt.classes;

import javax.persistence.*;

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
}
