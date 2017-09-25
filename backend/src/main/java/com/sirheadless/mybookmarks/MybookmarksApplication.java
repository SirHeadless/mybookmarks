package com.sirheadless.mybookmarks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class MybookmarksApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybookmarksApplication.class, args);
	}
}
