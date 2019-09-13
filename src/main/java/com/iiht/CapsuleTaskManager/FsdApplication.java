package com.iiht.CapsuleTaskManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = { "config", "com.cognizant.fsd" })
public class FsdApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(FsdApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(FsdApplication.class, args);
	}

}
