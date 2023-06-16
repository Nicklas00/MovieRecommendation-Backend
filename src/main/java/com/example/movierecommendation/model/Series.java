package com.example.movierecommendation.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@Getter
@Setter
@ToString
public class Series {
  public boolean adult;
  public String backdrop_path;
  public int id;
  public String name;
  public String original_language;
  public String original_name;
  public String overview;
  public String poster_path;
  public String media_type;
  public ArrayList<Integer> genre_ids;
  public double popularity;
  public String first_air_date;
  public double vote_average;
  public int vote_count;
  public ArrayList<String> origin_country;

}
