package site.metacoding.animalprojectfrontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class AnimalProjectFrontendApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimalProjectFrontendApplication.class, args);
	}

}
