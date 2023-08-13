package br.com.desafio.managementapi;

import org.flywaydb.core.Flyway;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class ManagementApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagementApiApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean(initMethod = "migrate")
	public Flyway flyway(ApplicationContext context) {
		return Flyway.configure().dataSource(context.getBean(DataSource.class)).load();
	}
}