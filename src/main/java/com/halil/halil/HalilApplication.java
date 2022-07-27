package com.halil.halil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class HalilApplication {

	public static void main(String[] args) {
		SpringApplication.run(HalilApplication.class, args);
	}

}
