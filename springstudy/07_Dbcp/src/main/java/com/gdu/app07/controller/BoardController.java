package com.gdu.app07.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.app07.domain.BoardDTO;
import com.gdu.app07.service.BoardService;

import lombok.AllArgsConstructor;

@Controller

// 필드를 이용한 생성자를 만들어 두면,
// 생성자의 매개변수로 컨테이너의 Bean이 자동 주입(@Autowired)되므로
// 필드에 @Autowired 처리할 필요가 없다.
@AllArgsConstructor
public class BoardController {
	
	// Controller는 Service를 사용합니다.
	@Autowired
	private BoardService boardService; // @Autowired가 없어도 null이 안되는 이유 : @AllArgsConstructor가 있기 때문
	
	/*
	public BoardController(BoardService boardService) { // @Autowired의 대체품. 생성자를 만들면 Autowired가 자동으로 들어온다.
		super();
		this.boardService = boardService;
	}
	*/

	@GetMapping("/") // 웰컴 페이지 등록
	public String index() {
		return "index";
	}
	
	@GetMapping("brd/list")
	   public String list(Model model) {   // Model은 forward 할 속성(attribute)을 저장할 때 사용한다.
	      model.addAttribute("boards", boardService.findAllBoards());
	      return "board/list";         // board 폴더의 list.jsp로 forward (redirect가 없으면 forward)
	   }

	
	@GetMapping("brd/write")
	public String write() {
		return "board/write"; // board 폴더의 write.jsp로 forward
	}
	
	@PostMapping("brd/add")
	public String add(BoardDTO board) {
		boardService.saveBoard(board); // saveBoard()로부터 0/1이 반환되지만 처리하지 않았다.
		return "redirect:/brd/list";
	}
	
	
	@GetMapping("brd/detail")
	public String detail(@RequestParam(value="board_no", required=false, defaultValue = "0") int board_no
			           , Model model) {
		model.addAttribute("board", boardService.findBoardByNo(board_no));
		return "board/detail";
	}
	
	@PostMapping("brd/edit")
	public String edit(int board_no
			         , Model model) {
		model.addAttribute("board", boardService.findBoardByNo(board_no));
		return "board/edit";
	}
	
	@PostMapping("brd/modify")
	public String modify(BoardDTO board) {
		boardService.modifyBoard(board); // modifyBoard()로부터 0/1이 반환되지만 처리하지 않음.
		return "redirect:/brd/detail?board_no=" + board.getBoard_no();
	}
	
	@PostMapping("brd/remove")
	public String remove(int board_no) {
		boardService.removeBoard(board_no); // removeBoard()로부터 0/1이 반환되지만 처리하지 않음.
		return "redirect:/brd/list";
	}
}
