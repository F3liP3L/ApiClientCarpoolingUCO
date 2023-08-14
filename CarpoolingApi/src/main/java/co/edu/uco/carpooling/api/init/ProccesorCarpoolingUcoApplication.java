package co.edu.uco.carpooling.api.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"co.edu.uco"})
public class ProccesorCarpoolingUcoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProccesorCarpoolingUcoApplication.class, args);
	}

}
