package com.initial.start.beans.postprocessors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class DepartmentSampleBean {

    private String environment;

    public DepartmentSampleBean()
    {
        System.out.println("\n Instantiation Phase :: DepartmentSampleBean Instantiated ....");
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
        System.out.println(" DepartmentSampleBean init() Method called ....");

    }

    public void getService()
    {
        System.out.println("\n Servicing Phase :: DepartmentSampleBean Ready to Give Service");
        System.out.println(" Env :: "+environment);
    }

    @PreDestroy
    public void destroy()
    {
        System.out.println("\n Destruction Phase :: DepartmentSampleBean destroy() Method invoked ....");

    }

}
