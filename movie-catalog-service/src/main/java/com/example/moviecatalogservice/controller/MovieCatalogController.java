package com.example.moviecatalogservice.controller;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.moviecatalogservice.model.CatalogItem;
import com.example.moviecatalogservice.model.Movie;
import com.example.moviecatalogservice.model.Rating;
import com.example.moviecatalogservice.model.UserRatings;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {
	

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	
	@GetMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		
		//get all rated movie Ids
		
	
		
		UserRatings ratings = restTemplate
				.getForObject("http://rating-data-service/rating/user/"+userId ,UserRatings.class);
//		.getForObject("http://localhost:8091/rating/user/"+userId ,UserRatings.class);
		//for each movie id , call movie info service and get details
		
		return ratings.getRatings().stream()
				.map(rating -> {
					Movie movie =  restTemplate.getForObject("http://movie-infos-service/movie/"+rating.getMovieId(), Movie.class);
//
//					Movie movie = webClientBuilder.build()
//						.get()
//						.uri("http://localhost:8090/movie/"+rating.getMovieId())
//						.retrieve()
//						.bodyToMono(Movie.class)
//						.block();
					
					return new CatalogItem(movie.getName(),movie.getDesc(),rating.getRating());
				})
				.collect(Collectors.toList());
	}

}
