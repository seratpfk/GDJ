package com.gdu.app03.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gdu.app03.domain.Notice;

@Configuration
public class SpringBeanConfig {
	
	@Bean
	public Notice notice1() { // <bean id="notice1" class="Notice">
		Notice notice = new Notice();
		notice.setNoticeNo(1); // <property name="noticeNo" value="1" />
		notice.setTitle("�Ϲݰ���"); // <property name="noticeNo" value="�Ϲݰ���" />
		return notice;
	}
	
	@Bean
	public Notice notice2() { // <bean id="notice2" class="Notice">
		return new Notice(2, "��ް���"); // constructor-arg calue="2" />
		                               // constructor-arg calue="��ް���" />
	}
}
