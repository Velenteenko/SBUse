package com.ua.ingk.spboot.initial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ua.ingk.spboot.initial.config.JpaConfig;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(new Class<?>[] { Application.class, JpaConfig.class }, args);
	}
}
