package com.spring.jpa.springbootjpa;

import com.spring.jpa.springbootjpa.demos.controller.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan
@EnableJpaRepositories
public class SpringbootJpaApplication implements CommandLineRunner {

    @Autowired
    ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJpaApplication.class, args);
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

        System.out.println(" \n\n ***** getAll()\n\n ");

        controller.getAll().stream().forEach(System.out::println);

        controller.update();

        System.out.println(" \n\n ***** After Update\n\n");

        controller.getAudits(1).stream().forEach(System.out::println);


        System.out.println(" \n\n ***** After Update 22\n\n");
        controller.getAuditsJQL(1).stream().forEach(System.out::println);


    }
}
