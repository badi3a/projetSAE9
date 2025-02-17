package tn.esprit.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tn.esprit.application.Repository.ApplicationRepository;

import java.util.Date;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private ApplicationRepository applicationRepository;
	@Bean
	public ApplicationRunner init() {
		return (args) -> {
			applicationRepository.save(new tn.esprit.application.Entity.Application(new Date(2024,04,14), "mannaiaaaa"));

		};
	}




}
