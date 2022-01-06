package com.initial.start.springbootcore;

import com.initial.start.bookmyshow.repository.FeedMovieRepository;
import com.initial.start.bookmyshow.controller.MovieController;
import com.initial.start.bookmyshow.exception.MovieNotFoundException;
import com.initial.start.bookmyshow.bean.Theater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.LinkedHashSet;
import java.util.Map;

@SpringBootApplication
@ComponentScan(basePackages = {"com.initial.start.bookmyshow"})
public class SpringbootCoreApplication implements CommandLineRunner {

	@Autowired
	ApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try
		{
			Map<String, LinkedHashSet<Theater>> response =
					applicationContext.getBean(MovieController.class).search("RRR");

			response.keySet().forEach(key ->
			{
				System.out.println(" \n\n **** Show Time :: "+key);
				response.get(key).stream().forEach(theater -> System.out.println(theater));
			});
		}catch (MovieNotFoundException exp)
		{
			System.out.println("\n\n **** Sorry !!! "+ exp.getMessage());
			System.out.println(" Available Movies "+applicationContext.getBean(FeedMovieRepository.class).getMoviesSet());
		}

	}


}
