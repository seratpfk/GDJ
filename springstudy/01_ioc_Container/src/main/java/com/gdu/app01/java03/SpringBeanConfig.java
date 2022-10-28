package com.gdu.app01.java03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBeanConfig {

	@Bean
	public Publisher publisher1() {
		Publisher publisher = new Publisher();
		publisher.setName("�ѱ����ǻ�");
		publisher.setTel("02-111-1111");
		return publisher;
	}
	
	@Bean
	public Book book1() {
		Book book = new Book();
		book.setTitle("�ҳ���");
		book.setAuthor("Ȳ����");
		book.setPublisher(publisher1());
		return book;
	}
}
