package com.initial.start.springbootcore;

import com.initial.start.beans.SampleController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.initial.start.beans"})
public class SpringbootCoreApplication implements CommandLineRunner {

	@Autowired
	ApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		applicationContext.getBean(SampleController.class).activity();
	}


}
