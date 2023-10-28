package co.edu.uco.carpooling.api.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"co.edu.uco.carpooling"})
@EntityScan(basePackages = {"co.edu.uco.carpooling"})
@EnableJpaRepositories(basePackages = {"co.edu.uco.carpooling"})
public class CarpoolingUcoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarpoolingUcoApiApplication.class, args);
	}

}
