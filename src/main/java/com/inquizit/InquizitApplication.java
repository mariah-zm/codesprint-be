package com.inquizit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class InquizitApplication {

	public static void main(String[] args) {
		SpringApplication.run(InquizitApplication.class, args);
	}

}
