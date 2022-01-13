package com.spring.jpa.springbootjpa.demos.repository;

import com.spring.jpa.springbootjpa.demos.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    Optional<List<UserEntity>> findByCityIgnoreCaseLike(String city);

}
