package com.sweta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


//Working and correct project
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableAutoConfiguration
//@ComponentScan(basePackages = {"com.sweta.repository","com.sweta.entity"})
public class SpringBootCoretestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCoretestApplication.class, args);
	}

}
