package com.metacube.EADASSIGNMENT6.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.metacube.EADASSIGNMENT6.service.MailSender;
import com.metacube.EADASSIGNMENT6.service.impl.MockMailSender;
import com.metacube.EADASSIGNMENT6.service.impl.SmtpMailSender;

@Configuration
public class AppConfig {
	
	@Bean
	@Primary
	public MailSender smtpMailSender(){
		return new SmtpMailSender();
	}
	
	@Bean
	public MailSender mockMailSender(){
		return new MockMailSender();
	}

}
