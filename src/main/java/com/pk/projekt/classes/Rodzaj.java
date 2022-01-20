package com.pk.projekt.classes;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "rodzaj")
public class Rodzaj {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(length = 11, name = "id")
  private int id;

  @Column(nullable = false, length = 255, unique = true, name = "nazwa")
  private String nazwa;

  @ManyToMany(mappedBy = "rodzaj", targetEntity = Film.class, cascade = CascadeType.ALL)
  private Set<Film> film;

  public void setNazwa(String Nazwa) {
    this.nazwa = Nazwa;
  }

  public int getId() {
    return id;
  }

  public String getNazwa() {
    return nazwa;
  }

  public Set<Film> getFilm() {
    return film;
  }
}
