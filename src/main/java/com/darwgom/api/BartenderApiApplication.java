package com.darwgom.api;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.darwgom"})
@EntityScan("com.darwgom.model")
@EnableJpaRepositories("com.darwgom.repository")
public class BartenderApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BartenderApiApplication.class, args);
	}

}
