package com.dennis.onlineshopinterview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
public class OnlineshopinterviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineshopinterviewApplication.class, args);
	}

}
