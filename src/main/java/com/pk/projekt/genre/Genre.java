package com.pk.projekt.genre;

import com.pk.projekt.movie.Movie;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "rodzaj")
public class Genre {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(length = 11, name = "id")
  private int id;

  @Column(nullable = false, length = 255, unique = true, name = "nazwa")
  private String name;

  @ManyToMany(mappedBy = "genre", targetEntity = Movie.class, cascade = CascadeType.ALL)
  private Set<Movie> movie;

  public void setName(String name) {
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Set<Movie> getMovie() {
    return movie;
  }
}
