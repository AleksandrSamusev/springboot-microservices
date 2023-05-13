package dev.practice.organisationservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableEurekaClient
@OpenAPIDefinition(
		info = @Info(
				title = "Organisation service REST APIs",
				description = "Organisation service REST APIs documentation",
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
				description = "Organisation service Doc",
				url = "https://www.me.me"
		)
)
public class OrganisationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganisationServiceApplication.class, args);
	}

}
