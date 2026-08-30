package com.jose.api_movie.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "actors")
@Data @NoArgsConstructor @AllArgsConstructor
public class Actor {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;
}
