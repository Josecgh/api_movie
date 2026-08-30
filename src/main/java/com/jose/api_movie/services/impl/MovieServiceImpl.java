package com.jose.api_movie.services.impl;

import com.jose.api_movie.exceptions.ResourceNotFoundException;
import com.jose.api_movie.models.Movie;
import com.jose.api_movie.repositories.MovieRepository;
import com.jose.api_movie.services.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

  
  private MovieRepository movieRepository;

  @Override
  public List<Movie> getAllMovies() {
    return movieRepository.findAll();
  }

  @Override
  public Movie getMovieById(Long id) {
    return movieRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Película no encontrada con ID: " + id));
  }

  @Override
  public Movie creatMovie(Movie movie) {
    return movieRepository.save(movie);
  }

  @Override
  public Movie updateMovie(Long id, Movie movieDetails) {
    Movie movie = getMovieById(id);
    movie.setTitle(movieDetails.getTitle());
    movie.setSynopsis(movieDetails.getSynopsis());
    movie.setYear(movieDetails.getYear());
    movie.setGenres(movieDetails.getGenres());
    movie.setActors(movieDetails.getActors());
    return movieRepository.save(movie);
  }

  @Override
  public void deleteMovie(Long id) {
    Movie movie = getMovieById(id);
    movieRepository.delete(movie);
  }

  @Override
  public List<Movie> searchByTitleOrGenre(String title, String genre) {
    if (title != null && !title.isBlank()) {
      return movieRepository.findByTitleContainingIgnoreCase(title);
    } else if (genre != null && !genre.isBlank()) {
      return movieRepository.findByGenreName(genre);
    }
    return getAllMovies();
  }

}
