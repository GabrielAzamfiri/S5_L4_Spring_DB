package com.example.S5_L4_Spring_DB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class S5L4SpringDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(S5L4SpringDbApplication.class, args);

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(S5L4SpringDbApplication.class);


		System.out.println("Fine Run");
	}

}
