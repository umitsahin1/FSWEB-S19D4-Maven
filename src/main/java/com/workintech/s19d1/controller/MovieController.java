package com.workintech.s19d1.controller;


import com.workintech.s19d1.dto.ActorRequest;
import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;


    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }


    @GetMapping
    public List<Movie> findAll(){
        return movieService.findAll();
    }

    @GetMapping("/{id")
    public Movie getById(@PathVariable Long id){
        return movieService.findById(id);
    }

    @PostMapping
    public Movie save(@RequestBody ActorRequest actorRequest){
       List<Movie> movies = actorRequest.getMovies();
       Actor actor = actorRequest.getActor();

        for (Movie movie : movies) {
            movie.addActor(actor);
        }
        return movieService.save(movies.get(1));
    }


    @DeleteMapping("/{id}")
    public void delete(@RequestBody Movie movie){
         movieService.delete(movie);
    }
}
