package com.pk.projekt.classes;

import javax.persistence.*;

@Entity
@Table(name = "komentarz")
public class Comment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(length = 11, name = "id")
  private int id;

  @Column(nullable = false, length = 255, name = "opis")
  private String description;

  @Column(nullable = false, length = 11, name = "ocena")
  private int mark;

  @ManyToOne
  @JoinColumn(name = "film_id", nullable = false)
  private Movie movie;

  public void setDescription(String description) {
    this.description = description;
  }

  public void setMark(int mark) {
    this.mark = mark;
  }

  public void setMovie(Movie movie) {
    this.movie = movie;
  }

  public int getId() {
    return id;
  }

  public String getDescription() {
    return description;
  }

  public int getMark() {
    return mark;
  }

  public Movie getMovie() {
    return movie;
  }
}
