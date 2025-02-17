package tn.esprit.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tn.esprit.job.Entity.Job;
import tn.esprit.job.Repository.JobRepository;

import java.util.Date;

@SpringBootApplication
public class JobApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobApplication.class, args);
	}

	@Autowired
	private JobRepository jobRepository;
	@Bean
	public ApplicationRunner init() {
		return (args) -> {
			jobRepository.save(new Job("atef", "mannaiaaaa", true,new Date()));

		};
	}



}
