package pl.adcom.teaimovieaop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.adcom.teaimovieaop.aspect.EmailAspect;
import pl.adcom.teaimovieaop.model.Movie;
import pl.adcom.teaimovieaop.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private MovieService movieService;
    Logger logger = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getMovies(){
        return movieService.getAllMovies();
    }

    @PostMapping
    @EmailAspect
    public void addNewMovie(@RequestBody Movie movie){
        movieService.addMovies(movie);
        logger.info("Film został dodany");
//        emailService.sendSimpleMessage("******", "test", "To jest testowa wiadomość");
    }

}
