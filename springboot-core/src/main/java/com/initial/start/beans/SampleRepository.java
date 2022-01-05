package com.initial.start.beans;


import org.springframework.stereotype.Repository;

@Repository
public class SampleRepository {

    public SampleRepository()
    {
        System.out.println(" SampleRepository !!! Object Created");
    }

    public void activity()
    {
        System.out.println(" Does DB Related Operations");
    }
}
