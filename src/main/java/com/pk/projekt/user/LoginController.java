package com.pk.projekt.user;

import com.pk.projekt.actor.Actor;
import com.pk.projekt.actor.ActorRepository;
import com.pk.projekt.director.DirectorRepository;
import com.pk.projekt.genre.Genre;
import com.pk.projekt.genre.GenreRepository;
import com.pk.projekt.movie.Movie;
import com.pk.projekt.movie.MovieRepository;
import com.pk.projekt.studio.StudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Controller
public class LoginController {

  @Autowired
  private UserRepository repoUser;

  @Autowired
  private MovieRepository repoMovie;

  @Autowired
  private ActorRepository repoActor;

  @Autowired
  private DirectorRepository repoDirector;

  @Autowired
  private GenreRepository repoGenre;

  @Autowired
  private StudioRepository repoStudio;

  @GetMapping("/login")
  private String loadPage(Model model) {
    model.addAttribute("user", new User());
    model.addAttribute("error", "huehue");
    return "login";
  }

  @PostMapping("/register")
  private String processRegister(User user, Model model) {
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    String encodedPassword = encoder.encode(user.getPassword());
    user.setPassword(encodedPassword);
    String error = "huehue";
    try {
      repoUser.save(user);
    } catch (Exception e) {
      error = "nie huehue";
    }
    model.addAttribute("error", error);
    model.addAttribute("user", new User());
    return "login";
  }

  @GetMapping("/search")
  private String viewAllFilms(@RequestParam("search") String search, Model model) {

    Set<Movie> movies = repoGenre.findMoviesByGenresPattern(search);
    movies.addAll(repoActor.findMoviesByActorsPattern(search));
    movies.addAll(repoMovie.findMoviesByPattern(search));

    movies = repoMovie.findMoviesASC(movies);

    model.addAttribute("movies", movies);

    return "movies-list";
  }

}
