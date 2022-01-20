package com.pk.projekt.classes;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "wytwornia")
public class Wytwornia {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(length = 11, name = "id")
  private int id;

  @Column(nullable = false, length = 255, unique = true, name = "nazwa")
  private String nazwa;

  @OneToMany(mappedBy = "wytwornia", targetEntity = Film.class, cascade = CascadeType.ALL)
  private Set<Film> film;


  public void setNazwa(String nazwa) {
    this.nazwa = nazwa;
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
