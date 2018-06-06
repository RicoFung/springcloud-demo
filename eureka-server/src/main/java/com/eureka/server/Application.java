package com.eureka.server;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer // Eureka Server 标识
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}) // Spring Boot 应用标识
public class Application
{
	public static void main(String[] args)
	{
		SpringApplication.run(Application.class, args);
	}
}