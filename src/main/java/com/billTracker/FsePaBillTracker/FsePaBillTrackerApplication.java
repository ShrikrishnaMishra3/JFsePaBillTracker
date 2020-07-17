package com.billTracker.FsePaBillTracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = "com.billTracker.FsePaBillTracker")
@EnableJpaRepositories(basePackages = "com.billTracker.FsePaBillTracker.repo")
@EntityScan("com.billTracker.FsePaBillTracker.model")
public class FsePaBillTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FsePaBillTrackerApplication.class, args);
	}

}
 