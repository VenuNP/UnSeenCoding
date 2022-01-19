package com.springbootrest.controller;

import com.springbootrest.dto.MovieDTO;
import com.springbootrest.exception.MovieNotFoundException;
import com.springbootrest.service.MovieService;
import com.springbootrest.utils.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;


    @PostMapping
    public ResponseEntity<MovieDTO> save(@RequestBody MovieDTO movieDTO) {
        return new ResponseEntity<>(movieService.save(movieDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDTO> update(@RequestBody MovieDTO movieDTO, @PathVariable("id") int id)
            throws MovieNotFoundException {
        movieDTO.setId(id);
        return new ResponseEntity<>(movieService.update(movieDTO), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> get(@PathVariable("id") int id)
            throws MovieNotFoundException {
        return new ResponseEntity<>(MapperUtils.getDTO(movieService.get(id)), HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id)
            throws MovieNotFoundException {

        movieService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping
    public ResponseEntity<List<MovieDTO>> getAll() {
        return new ResponseEntity<>(movieService.getAll(), HttpStatus.OK);
    }


    @GetMapping("/search")
    public ResponseEntity<List<MovieDTO>> search(@RequestParam("movieName") String name) {

        return new ResponseEntity<>(movieService.search(name), HttpStatus.OK);

    }
}
