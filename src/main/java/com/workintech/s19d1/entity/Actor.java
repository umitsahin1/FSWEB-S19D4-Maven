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
@Table(name="actor", schema="movie_api")
public class Actor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "first_name")
  @NotNull
  private String firstName;

  @Column(name = "last_name")
  @NotNull
  private String lastName;

  @Column(name = "gender")
  @Enumerated(EnumType.STRING)
  private Gender gender;

  @Column(name = "birth_date")
  private LocalDate birthDate;


  @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.EAGER)
  @JoinTable(name="movie_actor",
          joinColumns = @JoinColumn(name = "actor_id"),
          inverseJoinColumns = @JoinColumn(name = "movie_id"))
  private List<Movie> movies;

  public void addMovie(Movie movie){
    if(movies == null){
      movies= new ArrayList<>();
    }
    movies.add(movie);
  }
}
