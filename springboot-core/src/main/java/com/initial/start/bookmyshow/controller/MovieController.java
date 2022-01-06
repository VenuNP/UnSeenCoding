package com.initial.start.bookmyshow.controller;

import com.initial.start.bookmyshow.bean.Theater;
import com.initial.start.bookmyshow.exception.MovieNotFoundException;
import com.initial.start.bookmyshow.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.LinkedHashSet;
import java.util.Map;

@Controller
public class MovieController {

    @Autowired
     private MovieService movieService;

    public Map<String, LinkedHashSet<Theater>> search(String movieName) throws MovieNotFoundException
    {
        return movieService.search(movieName);
    }

}
