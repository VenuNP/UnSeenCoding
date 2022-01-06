package com.initial.start.beans.qualifier;

import org.springframework.stereotype.Component;

@Component
public class DataEngineering implements  Department {
    @Override
    public String getName() {
        return "DataEngineering-DEPT";
    }
}
