package com.example.movieinfosservice.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.movieinfosservice.model.Movie;

@RestController
@RequestMapping("/movie")
public class MovieController {
	
	@GetMapping("/{movieId}")
	private Movie getMovieInfo(@PathVariable("movieId") String movieId, HttpServletRequest request) {
		
		System.out.println("Ip : " + request.getRemoteAddr());
		Enumeration<String> headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements()) {
			String nextElement = headerNames.nextElement();
			System.out.println(nextElement +" ===== " + request.getHeader(nextElement));
		}
		return new Movie(movieId , "Dabang");
	}

}