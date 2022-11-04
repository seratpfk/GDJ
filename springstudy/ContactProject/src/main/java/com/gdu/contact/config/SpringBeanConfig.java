package com.gdu.contact.config;

import org.springframework.context.annotation.Bean;

import com.gdu.contact.service.ContactService;
import com.gdu.contact.service.ContactServiceImpl;



public class SpringBeanConfig {

	@Bean
	public ContactService contactService() {
		return new ContactServiceImpl();
	}
}
