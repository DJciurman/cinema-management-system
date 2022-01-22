package com.pk.projekt.director;

import com.pk.projekt.movie.Movie;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "rezyser")
public class Director {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(length = 11, name = "id")
  private int id;

  @Column(nullable = false, length = 255, name = "imie")
  private String firstName;

  @Column(nullable = false, length = 255, name = "nazwisko")
  private String lastName;

  @OneToMany(mappedBy = "director", targetEntity = Movie.class, cascade = CascadeType.ALL)
  private Set<Movie> movie;

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
