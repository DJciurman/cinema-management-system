package com.pk.projekt;

import com.pk.projekt.classes.Film;
import com.pk.projekt.classes.FilmRepository;
import com.pk.projekt.classes.Komentarz;
import com.pk.projekt.classes.KomentarzRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class KomentarzRepositoryTests {

  @Autowired
  private KomentarzRepository repoKomentarz;

  @Autowired
  private FilmRepository repoFilm;

  @Test
  public void testAddKomentarz() {

    Komentarz komentarz = new Komentarz();

//    komentarz.setOpis("Bardzo dobry serial - polecam Jan Chmielewski");
//    komentarz.setOcena(5);

    komentarz.setOpis("Ciekawa fabuła");
    komentarz.setOcena(5);

    Film film = repoFilm.findFilmById(1);

    komentarz.setFilm(film);

    repoKomentarz.save(komentarz);

  }

  @Test
  public void testModifyKomentarz() {

    Komentarz komentarz = repoKomentarz.findKomentarzById(1);
    komentarz.setOcena(5);

    repoKomentarz.save(komentarz);

  }
}
