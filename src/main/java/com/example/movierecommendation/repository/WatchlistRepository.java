package com.example.movierecommendation.repository;

import com.example.movierecommendation.model.Movie;
import com.example.movierecommendation.model.Watchlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WatchlistRepository extends JpaRepository<Watchlist, Long> {

  @Query("SELECT w FROM Watchlist w WHERE w.user.id = ?1")
  List<Movie> getWatchlistByUserIdQuery(long userId);

  List<Movie> getWatchlistByUserId(long userId);



}
