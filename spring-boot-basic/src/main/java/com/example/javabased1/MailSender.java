package com.example.javabased1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MailSender {

	@Autowired
	@Qualifier("emailMessenger")
	IMessenger messenger;
	
	public void showMessage() {
		messenger.sendMessage();
	}
	
	
}
