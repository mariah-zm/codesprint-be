package com.inquizit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class InquizitApplication {

	public static void main(String[] args) {
		SpringApplication.run(InquizitApplication.class, args);
	}

}
