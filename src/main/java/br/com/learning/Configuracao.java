package br.com.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Configuracao {
	

	public static void main(String[] args) {
		
		SpringApplication.run(Configuracao.class, args);
	}
	
//	@Bean
//	public DataSource dataSource(){
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("");
//		dataSource.setUrl("jdbc:mysql://localhost:3306/listavip");
//		dataSource.setUsername("root");
//		dataSource.setPassword("root");
//		
//		return dataSource;
//	}
	
	
}
