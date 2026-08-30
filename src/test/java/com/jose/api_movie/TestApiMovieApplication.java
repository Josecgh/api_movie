package com.jose.api_movie;

import org.springframework.boot.SpringApplication;

public class TestApiMovieApplication {

	public static void main(String[] args) {
		SpringApplication.from(ApiMovieApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
