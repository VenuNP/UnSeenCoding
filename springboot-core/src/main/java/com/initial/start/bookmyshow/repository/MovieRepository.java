package com.initial.start.bookmyshow.repository;

import com.initial.start.bookmyshow.exception.MovieNotFoundException;
import com.initial.start.bookmyshow.bean.Theater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class MovieRepository {
    @Autowired
    private FeedMovieRepository feedMovieRepository;

    public Map<String, List<Theater>> search(String movieName) throws MovieNotFoundException
    {
        Map<String, List<Theater>> showData =
                feedMovieRepository.getLookUpMap().get(movieName.toUpperCase());

        if(showData == null || showData.size() == 0)
        {
            throw new MovieNotFoundException(" Movies does not exist");
        }

        return showData;
    }
}
