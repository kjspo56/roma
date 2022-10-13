package com.board.roma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class RomaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RomaApplication.class, args);
	}

}
