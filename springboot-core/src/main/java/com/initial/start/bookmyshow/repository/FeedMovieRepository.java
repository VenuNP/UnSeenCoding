package com.initial.start.bookmyshow.repository;

import com.initial.start.bookmyshow.bean.Theater;
import org.springframework.stereotype.Repository;
import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@Repository
public class FeedMovieRepository {

    private Properties movies ;

    private Properties theaters ;

    Map<String, Map<String,List<Theater>> > moviesLookUPMap = null;
    Map<String,Theater> theaterMap = null;
    Set<String> moviesSet = null;

    @PostConstruct
    public void init()
    {
        try
        {
            InputStream moviesFin = new FileInputStream("movies.properties");
            InputStream theatersFin = new FileInputStream("theaters.properties");
            movies = new Properties();
            theaters = new Properties();
            movies.load(moviesFin);
            theaters.load(theatersFin);

        }catch (IOException exp)
        {
            exp.printStackTrace();
        }

        moviesLookUPMap  = new LinkedHashMap<>();
        theaterMap = new LinkedHashMap<>();
        Set<String> theaterIds =  theaters.stringPropertyNames();
        for(String id : theaterIds)
        {
            String[] value = theaters.getProperty(id).split(",");

            theaterMap.put(id,
                    Theater.builder()
                            .id(id)
                            .name(value[0])
                            .location(value[1])
                            .distance(Integer.valueOf(value[2]))
                            .price(Integer.valueOf(value[3]))
                            .build()
                    );
        }

        moviesSet =  movies.stringPropertyNames();
        //RRR= T1:S1-S2-S3-S4-S5-S6, T2:S1-S2-S6,T3:S1-S6,T4:S5-S6
        for(String movieName : moviesSet)
        {
            //{"T1:S1-S2-S3-S4-S5-S6", "T2:S1-S2-S6,T3:S1-S6","T4:S5-S6"}
            String[] showInfo = movies.getProperty(movieName).split(",");
            Map<String,List<Theater>> showDataMap = new LinkedHashMap<>();
            for(String showData : showInfo)
            {
                //"T1:S1-S2-S3-S4-S5-S6"
                String[] data = showData.split(":");
                String theaterId = data[0];

                //{"S1", "S2" ,"S3" ,"S4", "S5","S6"}
                String[] shows = data[1].split("-");

                Arrays.stream(shows).forEach(s ->
                {
                    showDataMap.putIfAbsent(s,new ArrayList<>());
                    showDataMap.get(s).add(theaterMap.get(theaterId));
                });

            }
            moviesLookUPMap.put(movieName.toUpperCase(),showDataMap);
        }

    }

    public  Map<String, Map<String,List<Theater>> > getLookUpMap()
    {
        return moviesLookUPMap;
    }

    public Set<String> getMoviesSet()
    {
        return moviesSet;
    }

}
