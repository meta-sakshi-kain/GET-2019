package com.metacube.EADASSIGNMENT6.service.impl;

import com.metacube.EADASSIGNMENT6.service.MailSender;

public class MockMailSender implements MailSender{

	@Override
	public String sendMail() {
		return "Mock mail sent";
	}
	

}
