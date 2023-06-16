package com.example.movierecommendation.service;

import com.example.movierecommendation.model.Movie;
import com.example.movierecommendation.model.Watchlist;
import com.example.movierecommendation.repository.WatchlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WatchlistService {

  private final WatchlistRepository watchlistRepository;

  @Autowired
  public WatchlistService(WatchlistRepository watchlistRepository){
    this.watchlistRepository = watchlistRepository;
  }

  public List<Movie> getWatchlistByUserId(Long id){
    return watchlistRepository.getWatchlistByUserId(id);
  }

  public Watchlist createWatchlist(Watchlist watchlist){
    return watchlistRepository.save(watchlist);
  }


}

