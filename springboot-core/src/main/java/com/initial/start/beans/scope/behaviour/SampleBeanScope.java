package com.initial.start.beans.scope.behaviour;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SampleBeanScope {

    public SampleBeanScope()
    {
        System.out.println("\n **** [SampleBeanScope Object is created] *** \n ");
    }

}
