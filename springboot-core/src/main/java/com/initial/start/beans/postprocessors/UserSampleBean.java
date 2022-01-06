package com.initial.start.beans.postprocessors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class UserSampleBean {


    private String environment;

    public UserSampleBean()
    {
        System.out.println("\n Instantiation Phase :: UserSampleBean Instantiated ....");
    }

    @Value("${environment}")
    public void setEnvironment(String environment)
    {
        this.environment = environment;
        System.out.println(" Setter Injection[Dependency Injection] Completed ");
    }

    @PostConstruct
    public void init()
    {
        System.out.println(" UserSampleBean init() Method called ....");
    }

    public void getService()
    {

        System.out.println("\n Servicing Phase :: UserSampleBean Ready to Give Service");
        System.out.println(" Env :: "+environment);

    }

    @PreDestroy
    public void destroy()
    {
        System.out.println("\n Destruction Phase :: UserSampleBean destroy() Method invoked ....");

    }

}
