package com.initial.start.bookmyshow.utils;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class ShowUtils {

    private Map<String, String> showTimings = null;

    @PostConstruct
    public void init()
    {
        showTimings = new LinkedHashMap<>();
        ShowTimes[] showTimes = ShowTimes.values();
        for(ShowTimes  show : showTimes)
        {
            showTimings.put(show.name().toUpperCase(),show.getTimings());
        }
    }
    public  String getTime(String show)
    {
        return  showTimings.get(show.toUpperCase());
    }
}
