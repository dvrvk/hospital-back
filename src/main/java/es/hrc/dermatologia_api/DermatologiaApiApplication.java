package es.hrc.dermatologia_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DermatologiaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DermatologiaApiApplication.class, args);
	}

}
