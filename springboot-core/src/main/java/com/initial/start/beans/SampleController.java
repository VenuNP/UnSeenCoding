package com.initial.start.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Controller
public class SampleController {

    private  SampleService sampleService;

    @Value("${spring.core.info}")
    private String  information;

    @Value("${environment}")
    private String environment;

    @Autowired
    public SampleController(SampleService sampleService)
    {
        System.out.println("Sample Controller Instantiated ");
        this.sampleService = sampleService;
    }

    public void activity()
    {
        System.out.println(" Does Service User Interactions");

        sampleService.activity();

        System.out.println(information+ " : "+environment);
    }
}
