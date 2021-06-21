package com.wyk.wisper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WisperApplication {

	public static void main(String[] args) {
		SpringApplication.run(WisperApplication.class, args);
	}

}
