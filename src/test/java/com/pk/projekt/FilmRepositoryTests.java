package com.pk.projekt;

import com.pk.projekt.classes.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class FilmRepositoryTests {

  @Autowired
  private FilmRepository repoFilm;

  @Autowired
  private RezyserRepository repoRezyser;

  @Autowired
  private WytworniaRepository repoWytwornia;

  @Autowired
  private AktorRepository repoAktor;

  @Autowired
  private RodzajRepository repoRodzaj;

  @Test
  public void testAddFilm() {

    Film film = new Film();

    film.setNazwa("The Flash");
    film.setOpis("Najszybszy człowiek na ziemi");

    Rezyser rezyser = repoRezyser.findRezyserById(1);

    film.setRezyser(rezyser);

    Wytwornia wytwornia = repoWytwornia.findWytworniaById(1);

    film.setWytwornia(wytwornia);

    Aktor aktor = repoAktor.findAktorById(1);

    film.getAktor().add(aktor);

    Rodzaj rodzaj = new Rodzaj();

    rodzaj = repoRodzaj.findRodzajById(2);

    film.getRodzaj().add(rodzaj);

    repoFilm.save(film);

  }
}
