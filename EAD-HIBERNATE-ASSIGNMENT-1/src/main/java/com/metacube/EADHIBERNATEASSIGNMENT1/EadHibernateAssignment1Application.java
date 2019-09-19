package com.metacube.EADHIBERNATEASSIGNMENT1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude=HibernateJpaAutoConfiguration.class)
public class EadHibernateAssignment1Application {

	public static void main(String[] args) {
		SpringApplication.run(EadHibernateAssignment1Application.class, args);
	}

}
