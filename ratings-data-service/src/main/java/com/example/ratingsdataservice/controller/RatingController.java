package com.example.ratingsdataservice.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ratingsdataservice.model.Rating;
import com.example.ratingsdataservice.model.UserRatings;

@RestController
@RequestMapping("/rating")
public class RatingController {
	
	@GetMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId ) {
		return new Rating(movieId, 5);
	}
	
	@GetMapping("/user/{userId}")
	public UserRatings getRatings(@PathVariable("userId") String userId){
		List<Rating> ratings =  Arrays.asList(
				new Rating("movie1", 5),
				new Rating("movie2", 4),
				new Rating("movie3", 3)
				);
		UserRatings userRatings = new UserRatings();
		userRatings.setRatings(ratings);
		return userRatings;
	}

}
