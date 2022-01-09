package com.springboot.jdbc.springbootjdbc;

import com.springboot.jdbc.demos.controller.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.springboot.jdbc.demos"})

public class SpringbootJdbcApplication implements CommandLineRunner {

	@Autowired
	private ApplicationContext applicationContext;
	public static void main(String[] args) {

		SpringApplication.run(SpringbootJdbcApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {


		UserController controller = applicationContext.getBean(UserController.class);

		/*
		controller.search("Hyd").stream().forEach(System.out::println);


		System.out.println(" \n\n ***** After");
		controller.update();
		controller.getAll().stream().forEach(System.out::println);

		 */

		controller.getAll().stream().forEach(System.out::println);

		controller.update();

		System.out.println(" \n\n ***** After Update");

		controller.getAudits(1).stream().forEach(System.out::println);




	}
}
