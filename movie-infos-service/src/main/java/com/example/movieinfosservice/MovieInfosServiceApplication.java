package com.example.movieinfosservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MovieInfosServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieInfosServiceApplication.class, args);
	}

}
