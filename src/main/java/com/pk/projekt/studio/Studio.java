package com.pk.projekt.studio;

import com.pk.projekt.movie.Movie;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "wytwornia")
public class Studio {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(length = 11, name = "id")
  private int id;

  @Column(nullable = false, length = 255, unique = true, name = "nazwa")
  private String name;

  @OneToMany(mappedBy = "studio", targetEntity = Movie.class, cascade = CascadeType.ALL)
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
