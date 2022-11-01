package com.gdu.app05.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.gdu.app05.domain.Board;

public class BoardServiceImpl implements BoardService {

	/*
		ResponseEntity<T> Ŭ����
		�ȳ�. �� Ajax ���� �����͸� ����� ���� ���� Ŭ������.
		
		new ResponseEntity<T>(T body, HttpHeaders header, HttpStatus status)
		1) T body : ���� ������ ������
		2) HttpHeaders header : ���� ���
		3) HttpStatus status : ���� �ڵ�(200, 404, 500 ��)
		
	 */
	
	@Override
	public ResponseEntity<Board> execute1(HttpServletRequest request) {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		Board board = null;
		
		ResponseEntity<Board> entity = null;
		if(title.isEmpty()) {
			entity = new ResponseEntity<Board>(board, HttpStatus.INTERNAL_SERVER_ERROR); // $.ajax()�� error���� ó�� // OK : 200, INTERNAL_SERVER_ERROR: 500 ����
		} else {
			board = new Board(title, content);
			entity = new ResponseEntity<Board>(board, HttpStatus.OK); // $.ajax()�� success���� ó��
		}
		
		return entity;
	}

	@Override
	public ResponseEntity<Board> execute2(String title, String content) {

		ResponseEntity<Board> entity = null;
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		
		if(title.isEmpty()) {
			entity = new ResponseEntity<Board>(HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			entity = new ResponseEntity<Board>(new Board(title, content), header, HttpStatus.OK);
		}
		
		return entity;
	}

	@Override
	public ResponseEntity<Board> execute3(Board board) {

		ResponseEntity<Board> entity = null;
		
		if(board.getTitle().isEmpty()) {
			entity = new ResponseEntity<Board>(HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			HttpHeaders header = new HttpHeaders();
			header.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
			entity = new ResponseEntity<Board>(board, header, HttpStatus.OK);
		}
		return entity;
	}

}
