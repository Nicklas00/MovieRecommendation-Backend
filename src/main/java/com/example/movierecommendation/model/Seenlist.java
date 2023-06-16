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
public class Seenlist {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "seenlist_id")
  private Long id;

  @OneToOne(cascade = CascadeType.MERGE)
  @JoinColumn(name = "user_id")
  private User user;

  @OneToMany(mappedBy = "seenlist", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Movie> movies;
}
