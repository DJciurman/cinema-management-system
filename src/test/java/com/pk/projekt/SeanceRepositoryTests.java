package com.pk.projekt;

import com.pk.projekt.classes.cinema.Cinema;
import com.pk.projekt.classes.cinema.CinemaRepository;
import com.pk.projekt.classes.movie.Movie;
import com.pk.projekt.classes.movie.MovieRepository;
import com.pk.projekt.classes.seance.Seance;
import com.pk.projekt.classes.seance.SeanceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.annotation.Rollback;

import java.sql.Date;
import java.sql.Time;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class SeanceRepositoryTests {

  @Autowired
  private SeanceRepository repoSeance;

  @Autowired
  private CinemaRepository repoCinema;

  @Autowired
  private MovieRepository repoMovie;

  @Test
  public void testAddSeance() {
    Seance seance = new Seance();

    Movie movie = repoMovie.findMovieById(1);
    Cinema cinema = repoCinema.findCinemaById(1);

    seance.setMovie(movie);
    seance.setCinema(cinema);
    seance.setDate(Date.valueOf("2022-02-15"));
    seance.setTime(Time.valueOf("11:11:11"));
    seance.setRoomNumber(1);

    repoSeance.save(seance);
  }
}
