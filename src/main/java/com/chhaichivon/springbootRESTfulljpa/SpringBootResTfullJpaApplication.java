package com.chhaichivon.springbootRESTfulljpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.chhaichivon.springbootRESTfulljpa.models")
@EnableJpaRepositories(basePackages = "com.chhaichivon.springbootRESTfulljpa.repository")
public class SpringBootResTfullJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootResTfullJpaApplication.class, args);
	}
}
