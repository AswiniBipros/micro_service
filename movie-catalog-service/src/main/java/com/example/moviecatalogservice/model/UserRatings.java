package com.example.moviecatalogservice.model;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRatings {
	
	private List<Rating> ratings;

}
