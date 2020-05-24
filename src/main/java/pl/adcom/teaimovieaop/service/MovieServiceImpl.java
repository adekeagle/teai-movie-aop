package pl.adcom.teaimovieaop.service;

import org.springframework.stereotype.Service;
import pl.adcom.teaimovieaop.model.Movie;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private List<Movie> movieList;

    public MovieServiceImpl() {
        movieList = new ArrayList<>();
        movieList.add(new Movie("Two Solitudes", 1978, "Compass Films"));
        movieList.add(new Movie("The Four Seasons", 1981, "Universal Pictures"));
        movieList.add(new Movie("30 Days of Night", 2007, "Columbia Pictures"));
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieList;
    }

    @Override
    public void addMovies(Movie movie) {
        movieList.add(movie);
    }
}

