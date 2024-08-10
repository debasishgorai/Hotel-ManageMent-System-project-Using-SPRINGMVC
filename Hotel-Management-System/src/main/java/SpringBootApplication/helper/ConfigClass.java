package SpringBootApplication.helper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigClass {
	@Bean
	public EntityManagerFactory getEmf() {
		return Persistence.createEntityManagerFactory("dev");
	}
	
	@Bean
	public EntityManager getEm() {
		return getEmf().createEntityManager();
	}
	
	@Bean
	public EntityTransaction getEt() {
		return getEm().getTransaction();
	}



}
