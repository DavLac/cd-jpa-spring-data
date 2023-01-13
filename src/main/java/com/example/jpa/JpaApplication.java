package com.example.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(JpaApplication.class, args);
		context.getBean(Main.class).run();
	}

}
