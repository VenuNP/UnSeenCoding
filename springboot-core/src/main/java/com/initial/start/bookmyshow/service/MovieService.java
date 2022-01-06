package com.initial.start.bookmyshow.service;

import com.initial.start.bookmyshow.exception.MovieNotFoundException;
import com.initial.start.bookmyshow.utils.ShowUtils;
import com.initial.start.bookmyshow.bean.Theater;
import com.initial.start.bookmyshow.repository.FeedMovieRepository;
import com.initial.start.bookmyshow.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private MovieRepository movieRepository;
    private FeedMovieRepository feedMovieRepository;
    private ShowUtils showUtils;

    @Autowired
    public MovieService(MovieRepository movieRepository, FeedMovieRepository feedMovieRepository, ShowUtils showUtils) {
        this.movieRepository = movieRepository;
        this.feedMovieRepository = feedMovieRepository;
        this.showUtils = showUtils;
    }

    public Map<String,LinkedHashSet<Theater>> search(String movieName) throws MovieNotFoundException
    {
        Map<String,LinkedHashSet<Theater>> response = new LinkedHashMap<>();
        Map<String, List<Theater>> showData = movieRepository.search(movieName);
        TreeSet<String> shows = showData.keySet().stream().collect(Collectors.toCollection(TreeSet::new));
        shows.stream().forEach(show ->
                {
                    List<Theater> theaterList = showData.get(show);
                 LinkedHashSet<Theater> sortedSet =
                         theaterList.stream().sorted(Comparator.comparing(Theater::getPrice))
                            .collect(Collectors.toCollection(LinkedHashSet::new));
                    response.put(showUtils.getTime(show),sortedSet);
                }
                );

        return  response;
    }

}
