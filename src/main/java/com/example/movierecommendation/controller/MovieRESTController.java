package com.example.movierecommendation.controller;

import com.example.movierecommendation.model.Movie;
import com.example.movierecommendation.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/movie")
public class MovieRESTController {

  private final MovieService movieService;

  @Autowired
  public MovieRESTController(MovieService movieService){
    this.movieService = movieService;
  }

  @PostMapping()
  public ResponseEntity<Movie> createMovie(@RequestBody Movie movie){
    return new ResponseEntity<>(movieService.save(movie), HttpStatus.CREATED);
  }

  @GetMapping()
  public ResponseEntity<List<Movie>> getMovieByWatchlistId(Long id){
    return new ResponseEntity<>(movieService.selectAllByWatchlistId(id), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Movie> deleteMovie(@PathVariable Long id){
    movieService.deleteById((id));
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
