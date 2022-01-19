package com.springbootrest.service;

import com.springbootrest.dto.MovieDTO;
import com.springbootrest.entity.MovieEntity;
import com.springbootrest.exception.MovieNotFoundException;
import com.springbootrest.repository.MovieRepository;
import com.springbootrest.utils.MapperUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;


    @Transactional(rollbackFor = Exception.class)
    public MovieDTO save(MovieDTO movieDTO) {
        MovieEntity entity =
                movieRepository.save(MapperUtils.getEntity(movieDTO));
        movieDTO.setId(entity.getId());

        return movieDTO;

    }

    @Transactional(rollbackFor = Exception.class)
    public MovieDTO update(MovieDTO movieDTO) throws MovieNotFoundException {
        MovieEntity entity = get(movieDTO.getId());
        movieRepository.save(MapperUtils.clone(entity, movieDTO));
        return movieDTO;
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer id) throws MovieNotFoundException {
        movieRepository.delete(get(id));
    }

    public MovieEntity get(int id) throws MovieNotFoundException {
        return movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException());
    }


    public List<MovieDTO> getAll() {
        List<MovieDTO> movieDTOS = new ArrayList<>();

        movieRepository.findAll().stream()
                .forEach(entity -> movieDTOS.add(MapperUtils.getDTO(entity)));
        return movieDTOS;
    }


    public List<MovieDTO> search(String name) {
        List<MovieDTO> movieDTOS = new ArrayList<>();

        movieRepository.findByNameIgnoreCaseLike("%" + name.trim() + "%")
                .orElse(Collections.emptyList())
                .forEach(entity -> movieDTOS.add(MapperUtils.getDTO(entity)));
        return movieDTOS;
    }


}


