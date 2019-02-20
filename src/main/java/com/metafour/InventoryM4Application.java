package com.metafour;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("com.metafour.service")
@EntityScan()
public class InventoryM4Application {

	public static void main(String[] args) {
		SpringApplication.run(InventoryM4Application.class, args);
	}

}
