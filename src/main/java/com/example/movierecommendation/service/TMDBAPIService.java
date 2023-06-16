package com.example.movierecommendation.service;

import com.example.movierecommendation.model.Movie;
import com.example.movierecommendation.model.Series;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TMDBAPIService {

  ObjectMapper om = new ObjectMapper();
  String trendingMovieApi = "https://api.themoviedb.org/3/trending/movie/week?api_key=454b5b0ff03def6077075d9344965270";
  String trendingTvApi = "https://api.themoviedb.org/3/trending/tv/week?api_key=454b5b0ff03def6077075d9344965270";

  public List getMovieListFromAPI(String api) throws IOException, InterruptedException {

    om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    String apiResponse = fetch(api);
    List<Movie> mediumList = om.readValue(getResultsFromApi(apiResponse), new TypeReference<List<Movie>>() {});

    return mediumList;
  }
  public List getTvListFromAPI(String api) throws IOException, InterruptedException {

    om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    String apiResponse = fetch(api);
    List<Series> SeriesList = om.readValue(getResultsFromApi(apiResponse), new TypeReference<List<Series>>() {});

    return SeriesList;
  }

  public static String fetch(String url) throws IOException, InterruptedException {
    //Create client
    HttpClient client = HttpClient.newHttpClient();

    //Create request
    HttpRequest request = HttpRequest.newBuilder(URI.create(url))
        .header("accept", "application/json")
        .GET()
        .build();

    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


    String myJSON = response.body();
    System.out.println(myJSON);
    return myJSON;

  }

  public String getResultsFromApi(String jsonString){
    JsonObject jsonObject = new JsonParser().parse(jsonString).getAsJsonObject();
    JsonElement jsonElement = jsonObject.get("results");
    String resultsString = jsonElement.toString();
    return  resultsString;
  }

}
