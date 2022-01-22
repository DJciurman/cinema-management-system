package com.pk.projekt;

import com.pk.projekt.actor.Actor;
import com.pk.projekt.actor.ActorRepository;
import com.pk.projekt.director.Director;
import com.pk.projekt.director.DirectorRepository;
import com.pk.projekt.genre.Genre;
import com.pk.projekt.genre.GenreRepository;
import com.pk.projekt.movie.Movie;
import com.pk.projekt.movie.MovieRepository;
import com.pk.projekt.studio.Studio;
import com.pk.projekt.studio.StudioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class MovieRepositoryTests {

  @Autowired
  private MovieRepository repoMovie;

  @Autowired
  private DirectorRepository repoDirector;

  @Autowired
  private StudioRepository repoStudio;

  @Autowired
  private ActorRepository repoActor;

  @Autowired
  private GenreRepository repoGenre;

  @Test
  public void testAddMovie() {

    Movie movie = new Movie();

    movie.setName("The Flash");
    movie.setDescription("Najszybszy człowiek na ziemi");

    Director director = repoDirector.findDirectorById(1);

    movie.setRezyser(director);

    Studio studio = repoStudio.findStudioById(1);

    movie.setWytwornia(studio);

    Actor actor = repoActor.findActorById(1);

    movie.getActor().add(actor);

    Genre genre = repoGenre.findGenreById(2);

    movie.getGenre().add(genre);

    repoMovie.save(movie);

  }
}
