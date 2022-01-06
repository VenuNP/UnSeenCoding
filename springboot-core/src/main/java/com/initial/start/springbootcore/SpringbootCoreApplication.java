package com.initial.start.springbootcore;

import com.initial.start.beanLifeCycle.SampleBean;
import com.initial.start.beans.SampleController;
import com.initial.start.beans.multi.resource.configuration.SampleResourceBean;
import com.initial.start.beans.postprocessors.DepartmentSampleBean;
import com.initial.start.beans.postprocessors.UserSampleBean;
import com.initial.start.beans.qualifier.Employee;
import com.initial.start.beans.scope.behaviour.SampleBeanScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.initial.start.beans.qualifier"})
public class SpringbootCoreApplication implements CommandLineRunner {

	@Autowired
	ApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		applicationContext.getBean(Employee.class).print();

	}


}
