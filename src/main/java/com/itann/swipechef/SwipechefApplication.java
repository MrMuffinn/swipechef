package com.itann.swipechef;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.itann.swipechef.persistence")
public class SwipechefApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwipechefApplication.class, args);
	}

}


