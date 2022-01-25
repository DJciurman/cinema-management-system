package com.pk.projekt.movie;

import com.pk.projekt.seance.Seance;
import com.pk.projekt.studio.Studio;
import com.pk.projekt.actor.Actor;
import com.pk.projekt.comment.Comment;
import com.pk.projekt.director.Director;
import com.pk.projekt.genre.Genre;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "film")
public class Movie {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(length = 11, name = "id")
  private int id;

  @Column(nullable = false, length = 255, name = "nazwa")
  private String name;

  @Column(length = 255, name = "opis")
  private String description;

  @ManyToOne
  @JoinColumn(name = "wytwornia_id", nullable = false)
  private Studio studio;

  @ManyToOne
  @JoinColumn(name = "rezyser_id", nullable = false)
  private Director director;

  @Column(length = 11, name = "rok", nullable = false)
  private int year;

  @Column(length = 11, name = "ocena", nullable = false)
  private int mark = 0;

  @OneToMany(mappedBy = "movie", targetEntity = Comment.class, cascade = CascadeType.ALL)
  private Set<Comment> comment;

  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
  @JoinTable(name = "rodzaj_film",
          joinColumns = {
                  @JoinColumn(name = "film_id", referencedColumnName = "id", nullable = false, updatable = false)},
                inverseJoinColumns = {
          @JoinColumn(name = "rodzaj_id", referencedColumnName = "id", nullable = false, updatable = false)})
  private Set<Genre> genre = new HashSet<>();

  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
  @JoinTable(name = "aktor_film",
  joinColumns = {
          @JoinColumn(name = "film_id", referencedColumnName = "id", nullable = false, updatable = false)},
          inverseJoinColumns = {
          @JoinColumn(name = "aktor_id", referencedColumnName = "id", nullable = false, updatable = false)})
  private Set<Actor> actor = new HashSet<>();

  @OneToMany(mappedBy = "movie", targetEntity = Seance.class, cascade = CascadeType.ALL)
  private Set<Seance> seance;

  public void setName(String name) {
    this.name = name;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setStudio(Studio studio) {
    this.studio = studio;
  }

  public void setDirector(Director director) {
    this.director = director;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public Studio getStudio() {
    return studio;
  }

  public Director getDirector() {
    return director;
  }

  public Set<Comment> getComment() {
    return comment;
  }

  public Set<Genre> getGenre() {
    return genre;
  }

  public Set<Actor> getActor() {
    return actor;
  }

  public Set<Seance> getSeance() {
    return seance;
  }

  public void setSeance(Set<Seance> seance) {
    this.seance = seance;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public int getMark() {
    return mark;
  }

  public void setMark(int mark) {
    this.mark = mark;
  }
}
