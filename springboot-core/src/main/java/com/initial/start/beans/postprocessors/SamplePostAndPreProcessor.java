package com.initial.start.beans.postprocessors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class SamplePostAndPreProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
       if(bean instanceof UserSampleBean || bean instanceof  DepartmentSampleBean) {
           System.out.println("\n Initialization Phase :: [ " + beanName + "] PRE-Processing Logic completed !!!");
       }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof UserSampleBean || bean instanceof  DepartmentSampleBean) {
            System.out.println("[ " + beanName + "] POST-Processing Logic completed !!! \n");
        }
        return bean;
    }
}
