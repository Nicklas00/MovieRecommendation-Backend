package com.example.movierecommendation.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Review {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "review_id")
  private Long id;

  @ManyToOne(cascade = CascadeType.MERGE)
  @JoinColumn(name = "movie_id")
  private Movie movie;

  @ManyToOne(cascade = CascadeType.MERGE)
  @JoinColumn(name = "user_id")
  private User user;

  @Column(length = 500)
  private String reviewText;

  private int rating;





}
