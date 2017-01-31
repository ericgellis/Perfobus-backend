package com.mobithink.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class MobithinkServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobithinkServerApplication.class, args);
	}
}
