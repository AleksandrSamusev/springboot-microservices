package dev.practice.employeeservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableFeignClients
//@EnableEurekaClient
@OpenAPIDefinition(
		info = @Info(
				title = "Employee service REST APIs",
				description = "Employee service REST APIs documentation",
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
				description = "Employee service Doc",
				url = "https://www.me.me"
		)
)
public class EmployeeServiceApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	@Bean
	public WebClient webClient() {
		return WebClient.builder().build();
	}

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
