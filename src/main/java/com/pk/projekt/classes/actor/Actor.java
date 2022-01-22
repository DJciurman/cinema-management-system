package com.pk.projekt.classes.actor;

import com.pk.projekt.classes.movie.Movie;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "aktor")
public class Actor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(length = 11, name = "id")
  private int id;

  @Column(nullable = false, length = 255, name = "imie")
  private String firstName;

  @Column(nullable = false, length = 255, name = "nazwisko")
  private String lastName;

  @ManyToMany(mappedBy = "actor", fetch = FetchType.LAZY, targetEntity = Movie.class)
  private Set<Movie> movie = new HashSet<>();

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public int getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public Set<Movie> getMovie() {
    return movie;
  }
}
