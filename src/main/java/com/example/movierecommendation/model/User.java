package com.example.movierecommendation.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.*;
import org.apache.catalina.SessionEvent;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class User {

  @Id
  @Column(name = "user_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(mappedBy = "user")
  private Watchlist watchlist;
  @OneToOne(mappedBy = "user")
  private Seenlist seenlist;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Review> reviews;
  @Column(name = "username", unique = true)
  private String username;
  @Column(name = "password")
  private String password;
  @Column(name = "email", unique = true)
  private String email;
}
