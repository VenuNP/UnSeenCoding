package com.initial.start.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SampleService {

    private  SampleRepository sampleRepository;

    public SampleService()
    {
        System.out.println("SampleService Instantiated ");
    }

    @Autowired
    public void setSampleRepository(SampleRepository sampleRepository)
    {
        this.sampleRepository = sampleRepository;
    }


    public void activity()
    {
        System.out.println(" Does Service Logics based on DB Data");

        sampleRepository.activity();
    }
}
