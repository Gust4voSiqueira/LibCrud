package br.com.libcrud;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "LibCrud",
				description = "Api com Crud simples para cursos",
				version = "1.0"
		)
)
public class LibCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibCrudApplication.class, args);
	}

}
