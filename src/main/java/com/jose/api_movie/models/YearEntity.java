package com.jose.api_movie.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "years")
@Data @NoArgsConstructor @AllArgsConstructor
public class YearEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, name = "release_year")
  private Integer releaseYear;
}
