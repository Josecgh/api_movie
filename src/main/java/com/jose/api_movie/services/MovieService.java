package com.jose.api_movie.services;

import java.util.List;

import com.jose.api_movie.models.Movie;

public interface MovieService {
  List<Movie> getAllMovies();
  Movie getMovieById(Long id);
  Movie creatMovie(Movie movie);
  Movie updateMovie(Long id, Movie movieDetails);
  void deleteMovie(Long id);
  List<Movie> searchByTitleOrGenre(String title, String genre);
}
