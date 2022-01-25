package com.pk.projekt.genre;

import com.pk.projekt.movie.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface GenreRepository extends JpaRepository<Genre, Integer> {

  @Query("SELECT g FROM Genre g ORDER BY g.name ASC")
  List<Genre> findAllGenresNameASC();

  @Query("SELECT g FROM Genre g WHERE g.id = ?1")
  Genre findGenreById(int id);

  @Query("SELECT g FROM Genre g WHERE g.name LIKE %?1%")
  Set<Genre> findGenresByPattern(String pattern);

  @Query("SELECT g.movie FROM Genre g WHERE g.name LIKE %?1%")
  Set<Movie> findMoviesByGenresPattern(String pattern);

  @Query("SELECT g.movie FROM Genre g WHERE g.id = 1")
  Set<Movie> findAllMovies();

  @Query("SELECT g.movie FROM Genre g WHERE g.id = 2")
  Set<Movie> findAllSeries();

  @Query("SELECT g FROM Genre g INNER JOIN g.movie m WHERE m = ?1 ORDER BY g.name ASC")
  Set<Genre> findAllMovieGenresASC(Movie movie);
}
