package com.example.spring2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Spring2Application {
	//args
//--spring.profiles.active=prod
	public static void main(String[] args) {
		SpringApplication.run(Spring2Application.class, args);
	}

}
