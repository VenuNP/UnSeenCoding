package com.initial.start.beans.qualifier;

import org.springframework.stereotype.Component;

@Component
public class Java implements  Department {
    @Override
    public String getName() {
        return "JAVA-DEPT";
    }
}
