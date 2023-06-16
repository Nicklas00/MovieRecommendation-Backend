package com.example.movierecommendation.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Movie {
  @Id
  @Column(name = "movie_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long movieId;

  @ManyToOne(cascade = CascadeType.MERGE)
  @JoinColumn(name = "watchlist_id")
  private Watchlist watchlist;

  @ManyToOne(cascade = CascadeType.MERGE)
  @JoinColumn(name = "seenlist_id")
  private Seenlist seenlist;

  @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Review> reviews;

  public boolean adult;
  public String backdrop_path;

  @Transient
  public List<Integer> genre_ids;

  public int id;
  public String original_language;
  public String original_title;
  public String overview;
  public double popularity;
  public String poster_path;
  public String release_date;
  public String title;
  public boolean video;
  public double vote_average;
  public int vote_count;
}

