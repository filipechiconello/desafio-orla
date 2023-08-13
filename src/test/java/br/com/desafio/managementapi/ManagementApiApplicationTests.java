package br.com.desafio.managementapi;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootTest
class ManagementApiApplicationTests {

	@Test
	void contextLoads() {
	}

	@Bean(initMethod = "migrate")
	public Flyway flyway(ApplicationContext context) {
		return Flyway.configure().dataSource(context.getBean(DataSource.class)).load();
	}

}
