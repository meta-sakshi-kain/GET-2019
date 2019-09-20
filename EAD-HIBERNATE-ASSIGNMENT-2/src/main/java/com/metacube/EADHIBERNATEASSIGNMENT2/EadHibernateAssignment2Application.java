package com.metacube.EADHIBERNATEASSIGNMENT2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude=HibernateJpaAutoConfiguration.class)
public class EadHibernateAssignment2Application {

	public static void main(String[] args) {
		SpringApplication.run(EadHibernateAssignment2Application.class, args);
	}

}
