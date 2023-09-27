package com.github.macieryann;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		String macie = "hello world";
		System.out.println("hi " + macie);
		SpringApplication.run(DemoApplication.class, args);
	}

}
