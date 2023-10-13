package com.nikospap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@Configuration
@EnableJpaAuditing
@EnableAsync
@EnableScheduling
public class NationBackendApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(NationBackendApplication.class, args);
	}

}
