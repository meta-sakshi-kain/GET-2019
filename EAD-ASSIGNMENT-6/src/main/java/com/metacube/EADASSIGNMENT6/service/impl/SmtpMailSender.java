package com.metacube.EADASSIGNMENT6.service.impl;

import com.metacube.EADASSIGNMENT6.service.MailSender;

public class SmtpMailSender implements MailSender {
	
	@Override
	public String sendMail(){
		return "Smtp Mail sent";
	}

}
