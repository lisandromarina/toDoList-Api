package com.toDoList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;


@SpringBootApplication
public class ToDoListApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToDoListApplication.class, args);
	}
	
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("https://localhost:8080/folder/getAllFolders")
			.allowedOrigins("*")
			.allowedMethods("PUT","DELETE", "GET", "POST")
				.allowedHeaders("strict-origin-when-cross-origin")
			.exposedHeaders("header1", "header2")
			.allowCredentials(false).maxAge(3600);
	}
}
