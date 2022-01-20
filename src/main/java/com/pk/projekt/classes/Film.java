package com.pk.projekt.classes;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "film")
public class Film {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(length = 11, name = "id")
  private int id;

  @Column(nullable = false, length = 255, name = "nazwa")
  private String nazwa;

  @Column(length = 255, name = "opis")
  private String opis;

  @ManyToOne
  @JoinColumn(name = "wytwornia_id", nullable = false)
  private Wytwornia wytwornia;

  @ManyToOne
  @JoinColumn(name = "rezyser_id", nullable = false)
  private Rezyser rezyser;

  @OneToMany(mappedBy = "film", targetEntity = Komentarz.class, cascade = CascadeType.ALL)
  private Set<Komentarz> komentarz;

  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
  @JoinTable(name = "rodzaj_film",
          joinColumns = {
                  @JoinColumn(name = "film_id", referencedColumnName = "id", nullable = false, updatable = false)},
                inverseJoinColumns = {
          @JoinColumn(name = "rodzaj_id", referencedColumnName = "id", nullable = false, updatable = false)})
  private Set<Rodzaj> rodzaj = new HashSet<>();

  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
  @JoinTable(name = "aktor_film",
  joinColumns = {
          @JoinColumn(name = "film_id", referencedColumnName = "id", nullable = false, updatable = false)},
          inverseJoinColumns = {
          @JoinColumn(name = "aktor_id", referencedColumnName = "id", nullable = false, updatable = false)})
  private Set<Aktor> aktor = new HashSet<>();

  public void setNazwa(String nazwa) {
    this.nazwa = nazwa;
  }

  public void setOpis(String opis) {
    this.opis = opis;
  }

  public void setWytwornia(Wytwornia wytwornia) {
    this.wytwornia = wytwornia;
  }

  public void setRezyser(Rezyser rezyser) {
    this.rezyser = rezyser;
  }

  public int getId() {
    return id;
  }

  public String getNazwa() {
    return nazwa;
  }

  public String getOpis() {
    return opis;
  }

  public Wytwornia getWytwornia() {
    return wytwornia;
  }

  public Rezyser getRezyser() {
    return rezyser;
  }

  public Set<Komentarz> getKomentarz() {
    return komentarz;
  }

  public Set<Rodzaj> getRodzaj() {
    return rodzaj;
  }

  public Set<Aktor> getAktor() {
    return aktor;
  }
}
