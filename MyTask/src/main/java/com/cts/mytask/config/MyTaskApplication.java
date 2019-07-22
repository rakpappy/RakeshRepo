package com.cts.mytask.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.cts.*")
public class MyTaskApplication {
	

	public static void main(String[] args) {
		
		SpringApplication.run(MyTaskApplication.class, args);
		
	}

}
