package com.workintech.s19d1.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="movie", schema="movie_api")
public class Movie {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long  id;

  @Column(name = "name")
  @NotNull(message = "Film adı null olamaz")
  private String name;

  @Column(name = "director_name")
  @NotNull(message = "Yönetmen adı null olamaz")
  private String directorName;

  @Column(name = "rating")
  private Integer rating;

  @Column(name = "release_date")
  private LocalDate releaseDate;

  @ManyToMany
  @JoinTable(name="movie_actor",
          joinColumns = @JoinColumn(name = "movie_id"),
          inverseJoinColumns = @JoinColumn(name = "actor_id"))
  private List<Actor> actors;

  public void addActor(Actor actor){
    if(actors == null){
      actors= new ArrayList<>();
    }
    actors.add(actor);
  }
}
