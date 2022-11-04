package com.gdu.app07.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gdu.app07.repogitory.BoardDAO;
import com.gdu.app07.service.BoardService;
import com.gdu.app07.service.BoardServiceImpl;

@Configuration
public class BoardAppContext { 

	@Bean
	public BoardDAO dao() { // BoardDAO의 @Repository 대체
		return new BoardDAO();
	}
	
	@Bean
	public BoardService boardService() { // BoardServiceImpl의 @Service 대체
		return new BoardServiceImpl(dao());
	}
}
