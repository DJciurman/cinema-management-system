package com.pk.projekt.classes;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "rezyser")
public class Rezyser {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(length = 11, name = "id")
  private int id;

  @Column(nullable = false, length = 255, name = "imie")
  private String imie;

  @Column(nullable = false, length = 255, name = "nazwisko")
  private String nazwisko;

  @OneToMany(mappedBy = "rezyser", targetEntity = Film.class, cascade = CascadeType.ALL)
  private Set<Film> film;

  public void setImie(String imie) {
    this.imie = imie;
  }

  public void setNazwisko(String nazwisko) {
    this.nazwisko = nazwisko;
  }

  public int getId() {
    return id;
  }

  public String getImie() {
    return imie;
  }

  public String getNazwisko() {
    return nazwisko;
  }

  public Set<Film> getFilm() {
    return film;
  }
}
