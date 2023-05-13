package dev.practice.departmentservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
		info = @Info(
				title = "Department service REST APIs",
				description = "Department service REST APIs documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Me",
						email = "me@me.me",
						url = "https://www.me.me"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.me.me"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Department service Doc",
				url = "https://www.me.me"
		)
)
@SpringBootApplication
//@EnableEurekaClient
public class DepartmentServiceApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

}
