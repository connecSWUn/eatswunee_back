package com.swulab.eatswunee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

@SpringBootApplication
public class EatswuneeApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(EatswuneeApplication.class);
		application.addListeners(new ApplicationPidFileWriter());
		application.run(args);
	}

}