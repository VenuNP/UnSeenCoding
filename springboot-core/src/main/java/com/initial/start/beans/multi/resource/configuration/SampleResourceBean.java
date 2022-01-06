package com.initial.start.beans.multi.resource.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("tech.yml")
@PropertySource("company.yml")
public class SampleResourceBean {

    @Value("${company.name}")
    private String companyName;
    @Value("${u.name}")
    private String userName;
    @Value("${environment}")
    private String environment;


    public void print()
    {
        System.out.println("*** [ Company Name ] ***:: "+companyName);
        System.out.println("*** [ User Name ] ***:: "+userName);
        System.out.println("*** [ Environment ] ***:: "+environment);
    }
}
