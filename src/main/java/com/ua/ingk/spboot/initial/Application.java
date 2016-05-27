package com.ua.ingk.spboot.initial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

import com.ua.ingk.spboot.initial.config.JpaConfig;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {

		return builder.sources(Application.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(new Class<?>[] { Application.class, JpaConfig.class }, args);
	}
}
