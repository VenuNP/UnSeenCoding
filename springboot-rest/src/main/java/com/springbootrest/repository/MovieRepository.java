package com.springbootrest.repository;

import com.springbootrest.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Integer> {

    Optional<List<MovieEntity>> findByNameIgnoreCaseLike(String name);


}
