package com.postapi2.postapi2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class PostApi2Application {

	public static void main(String[] args) {
		SpringApplication.run(PostApi2Application.class, args);
	}
}
