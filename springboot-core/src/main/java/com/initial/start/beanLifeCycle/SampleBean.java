package com.initial.start.beanLifeCycle;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class SampleBean {

    private String environment;

    public SampleBean()
    {
        System.out.println("\n Instantiation Phase :: SampleBean Instantiated ....");
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
        System.out.println("\n Initialization Phase :: SampleBean init() Method called ....");

    }

    public void getService()
    {
        System.out.println("\n Servicing Phase :: SampleBean Ready to Give Service");
    }

    @PreDestroy
    public void destroy()
    {
        System.out.println("\n Destruction Phase :: SampleBean destroy() Method invoked ....");

    }

}
