package pl.adcom.teaimovieaop.service;

import pl.adcom.teaimovieaop.model.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> getAllMovies();
    void addMovies(Movie movie);
}
