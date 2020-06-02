package com.itann.swipechef;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.itann.swipechef.config","com.itann.swipechef.controllers","com.itann.swipechef.domain","com.itann.swipechef.persistence","com.itann.swipechef.services" })
public class SwipechefApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwipechefApplication.class, args);
	}

}


