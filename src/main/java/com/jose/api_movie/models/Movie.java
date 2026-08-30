package com.jose.api_movie.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "movies")
@Data @NoArgsConstructor @AllArgsConstructor
public class Movie {
  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(length = 1000)
    private String synopsis;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "year_id")
    private YearEntity year;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "movie_genres",
        joinColumns = @JoinColumn(name = "movie_id"),
        inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genre> genres = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "movie_actors",
        joinColumns = @JoinColumn(name = "movie_id"),
        inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private Set<Actor> actors = new HashSet<>();
}
