package com.pk.projekt.classes;

import javax.persistence.*;

@Entity
@Table(name = "komentarz")
public class Komentarz {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(length = 11, name = "id")
  private int id;

  @Column(nullable = false, length = 255, name = "opis")
  private String opis;

  @Column(nullable = false, length = 11, name = "ocena")
  private int ocena;

  @ManyToOne
  @JoinColumn(name = "film_id", nullable = false)
  private Film film;

  public void setOpis(String opis) {
    this.opis = opis;
  }

  public void setOcena(int ocena) {
    this.ocena = ocena;
  }

  public void setFilm(Film film) {
    this.film = film;
  }

  public int getId() {
    return id;
  }

  public String getOpis() {
    return opis;
  }

  public int getOcena() {
    return ocena;
  }

  public Film getFilm() {
    return film;
  }
}
