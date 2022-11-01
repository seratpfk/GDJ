package com.gdu.app05;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdu.app05.domain.Board;
import com.gdu.app05.service.BoardService;

@Controller
public class MyController2 {

	@GetMapping("board")
	public String board() {
		return "board"; // board.jsp�� forward
	}
	
	@Autowired
	private BoardService boardService;
	
	@ResponseBody
	@GetMapping(value="board/detail1"
	          , produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Board> detail1(HttpServletRequest request){
		return boardService.execute1(request);
	}

	@ResponseBody
	@GetMapping("board/detail2") // produces�� ������ ����! ��ȯ�� ResponseEntity�� ���� �ڵ带 �ۼ��Ͽ���
	public ResponseEntity<Board> detail2(@RequestParam(value="title") String title, @RequestParam(value="content") String content) {
	return boardService.execute2(title, content);
	}
	
	@ResponseBody
	@GetMapping("board/detail3")  // �̹����� produces�� ����
	   public ResponseEntity<Board> detail3(Board board) {
	      return boardService.execute3(board);
	   }
}
