package com.gymapp.gymappbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GymAppBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(GymAppBackendApplication.class, args);
	}

}



/*

Controller → handles API requests

Service → contains business logic

DTO → carries data between client and backend

Repository → talks to database (CRUD operations)

Entity → represents database table structure*/
