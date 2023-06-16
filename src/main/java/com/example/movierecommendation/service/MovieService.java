package com.example.movierecommendation.service;

import com.example.movierecommendation.model.Movie;
import com.example.movierecommendation.repository.MovieRepository;
import com.example.movierecommendation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

  private final MovieRepository movieRepository;

  @Autowired
  public MovieService(MovieRepository movieRepository){
    this.movieRepository = movieRepository;

  }

  public Movie save(Movie movie){
    return movieRepository.save(movie);
  }

  public void deleteById(Long id){
    movieRepository.deleteById(id);
  }


  public List<Movie> selectAllByWatchlistId(Long id){
    return movieRepository.getMoviesByWatchlistId(id);
  }
}
