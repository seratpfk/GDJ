package com.gdu.app10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.app10.domain.BoardDTO;
import com.gdu.app10.service.BoardService;



// 필드를 이용한 생성자를 만들어 두면,
// 생성자의 매개변수로 컨테이너의 Bean이 자동 주입(@Autowired)되므로
// 필드에 @Autowired 처리할 필요가 없다.


@Controller
public class BoardController {


	@Autowired
	private BoardService boardService;
	

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	
	@GetMapping("brd/list")
	public String list(Model model) {  // Model은 forward할 속성(Attribute)을 저장할 때 사용한다.
		model.addAttribute("boards", boardService.findAllBoards());
		return "board/list";  // board 폴더의 list.jsp로 forward
	}
	
	
	@GetMapping("brd/write")
	public String write() {
		return "board/write";  // board 폴더의 write.jsp로 forward
	}
	
	
	@PostMapping("brd/add")
	public String add(BoardDTO board) {
		boardService.saveBoard(board);  // saveBoard()로부터 0/1이 반환되지만 처리하지 않았다.
		return "redirect:/brd/list";
	}	
	
	
	@GetMapping("brd/detail")
	public String detail(@RequestParam(value="boardNo", required=false, defaultValue="0") int boardNo
			           , Model model) {
		model.addAttribute("board", boardService.findBoardByNo(boardNo));
		return "board/detail";  // board 폴더의 detail.jsp로 forward 
	}
	
	
	@PostMapping("brd/edit")
	public String edit(int boardNo
			         , Model model) {
		model.addAttribute("board", boardService.findBoardByNo(boardNo));
		return "board/edit";  // board 폴더의 edit.jsp로 forward 
	}
	
	
	@PostMapping("brd/modify")
	public String modify(BoardDTO board) {
		boardService.modifyBoard(board);  // modifyBoard()로부터 0/1이 반환되지만 처리하지 않았다.
		return "redirect:/brd/detail?boardNo=" + board.getBoardNo();
	}
	
	
	@PostMapping("brd/remove")
	public String remove(int boardNo) {
		boardService.removeBoard(boardNo);  // removeBoard()로부터 0/1이 반환되지만 처리하지 않았다.
		return "redirect:/brd/list";
	}
	

	
}
