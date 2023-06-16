package com.example.movierecommendation.controller;

import com.example.movierecommendation.service.TMDBAPIService;
import com.example.movierecommendation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/tmdb")
public class TMDBApiRESTController {

  private final TMDBAPIService tmdbapiService;
  @Autowired
  public TMDBApiRESTController(TMDBAPIService tmdbapiService){
    this.tmdbapiService = tmdbapiService;
  }

  @GetMapping("/trending/movies")
  public ResponseEntity<List> getTrendingMovies(@RequestParam("api") String api) throws IOException, InterruptedException {
    return new ResponseEntity<>(tmdbapiService.getMovieListFromAPI(api), HttpStatus.OK);
  }
  @GetMapping("/trending/tv")
  public ResponseEntity<List> getTrendingSeries(@RequestParam("api") String api) throws IOException, InterruptedException {
    return new ResponseEntity<>(tmdbapiService.getTvListFromAPI(api), HttpStatus.OK);
  }


}
