package com.initial.start.beans.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Employee {

    @Autowired
    @Qualifier("java")
    private Department javaDepartment;

    @Autowired
    @Qualifier("dataEngineering")
    private Department dataEngDepartment;

    public void print()
    {
        System.out.println(" ***** [ Department Name ] "+javaDepartment.getName());
        System.out.println(" ***** [ Department Name ] "+dataEngDepartment.getName());

    }
}
