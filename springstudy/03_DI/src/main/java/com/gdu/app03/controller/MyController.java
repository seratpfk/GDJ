package com.gdu.app03.controller;

import javax.inject.Qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gdu.app03.domain.Board;
import com.gdu.app03.domain.Notice;

@Controller
public class MyController {

	/*
		@RequestMapping(value="/", method=RequestMethod.GET)
		
		Spring4���� ���ο� �ֳ����̼����� �ٲ� �� �ִ�.
		
		@GetMapping("/")
		@PostMapping("/")
		
	 */
	@RequestMapping("/") // http://localhost:9090/app03���� �����ϸ� ó���Ǵ� �޼ҵ�
	public String welcome() {
		return "default";
		// ViewResolver�� ���ؼ�
		// return "/WEB-INF/views/default.jsp"�� �ؼ��ȴ�.
	}
	
	/*
		Container�� ��ϵ� Bean�� �������� ���
		
		@Inject    : 
			1) Ÿ��(class)�� ��ġ�ϴ� Bean�� �������� �ֳ����̼�
			2) ���� Ÿ���� ���� �� �ִ� ��� @Qualifier�� �̿��ؼ� Bean�� �ĺ�
		@Resource  : 
			1) �̸�(id)��    ��ġ�ϴ� Bean�� �������� �ֳ����̼�
		@Autowired : 
			1) Ÿ��(class)�� ��ġ�ϴ� Bean�� �������� �ֳ����̼�
			2) ���� Ÿ���� ���� �� �ִ� ��� �ڵ����� @Qualifier�� ����ؼ� Bean�� �ĺ�
			3) �ǹ����� �ַ� ���
	 */
	
	/*
		@Autowired ��� ���
		
		1. �ʵ�� ������ Bean ��������
			1) �ʵ帶�� @Autowired�� �߰��Ѵ�. (�ʵ尡 10���̸� @Autowired�� 10�� �ۼ�)
			2) �ʵ尡 ������ ������� �ʴ´�.
		2. �����ڸ� �̿��� Bean ��������
			1) �������� �Ű������� Bean�� �����´�.
			2) @Autowired�� �ۼ��� �ʿ䰡 ����.
		3. �޼ҵ带 �̿��� Bean ��������
			1) �޼ҵ��� �Ű������� Bean�� �����´�.
			2) @Autowired�� �ۼ��ؾ� �Ѵ�.
			3) �Ϲ������� setter�� ��������� setter�� �ƴϾ ��� ����.
			
	 */
	
	// 1. �ʵ�� ������ Bean ��������
	// @Autowired
	// private Board board;
	
	/*
		@Autowired�� Ÿ��(class)�� ��ġ�ϴ� Bean�� Container���� �����´�.
		
		@Autowird
		private Board board; // Ÿ���� Board�� Bean�� Container���� �������Ŷ�.
		
		---- Container ------------------
		<bean id="board1" class="Board">
		<!-- <bean id="board2" class="Board"> -->
		---------------------------------
	 */
	
	/*
	// 2. �����ڸ� �̿��� Bean ��������
	private Board board;
	
	@Autowired // �����ڿ��� @Autowired�� ������ �� �ִ�.
	public MyController(Board board) { // �Ű����� Board board�� Ÿ���� Board�� Bean�� Container���� �������Ŷ�.
		super();
		this.board = board;
	}
	*/

	
	/*
	// 3. �޼ҵ带 �̿��� Bean ��������
	private Board board;

	@Autowired // �Ϲ� �޼ҵ�� @Autowired�� �ݵ�� �ۼ��ؾ� �Ѵ�.
	public void setBoard(Board board) { // �Ű����� Board board�� Board Ÿ���� Bean�� Container���� �������Ŷ�.
		this.board = board;
	}
	*/
	
	// 4. ������ Ÿ���� Bean�� ���� �� ��ϵ� ���
	//	1) �������� �ڵ����� �ĺ���(Qualifier)�� �ν��Ѵ�.
	//  2) �ĺ���(@Qualifier)�� Bean�� �̸�(id)�� ��ġ�ϴ� Bean�� �����´�.
	
	// 4-1. �ʵ�� ������ Bean ��������
	/*
	@Autowired
	private Board board1; // board1�� b1���� �ٲٸ� root-context.xml���Ͽ��� ��������.
	
	@Autowired
	private Board board2;
	*/
	
	// 4-2. �����ڸ� �̿��� Bean ��������
	/*
	private Board b1;
	private Board b2;
	public MyController(Board board1, Board board2) { // field�� ���ԵǴ� ���� �ƴ� ����� ���Եȴ�. �Ű������� �̸� ���߸� �����.
		b1=board1;  // �Ű��������� Bean�� �̸�(id)�� ��ġ�ϹǷ� �ڵ����� ���Եȴ�.
		b2=board2;
	}
	*/
	
	
	// 4-3. �޼ҵ带 �̿��� Bean ��������
	private Board b1;
	private Board b2;
	
	/*
	@Autowired
	public void setB1(Board b1) {
		this.b1 = b1;
	}


	@Autowired
	public void setB2(Board b2) {
		this.b2 = b2;
	}
	*/ // qualifying ���� �߻�

	@Autowired
	public void setB1(Board board1, Board board2) {
		this.b1 = board1;
		this.b2 = board2;
	}



	@GetMapping("board/detail") // @GetMapping("/board/detail")
	public void boardDetail() {
		System.out.println(b1.getBoardNo());
		System.out.println(b1.getTitle());
		System.out.println(b1.getCreateDate());
		System.out.println(b2.getBoardNo());
		System.out.println(b2.getTitle());
		System.out.println(b2.getCreateDate());
	}
	
	/*
		@Inject : ���� Ÿ��(class)�� Ȯ��
		���� Ÿ���� �ټ� �߰ߵǸ�
		@Qualifier�� ���ؼ� �̸�(id)�� ����
		@Qualifier�� ������ ���� ����
		
		@Resource : �̸�(id)���� Ȯ��
		
		@Autowired : �ϴ� Ÿ��(class) Ȯ��
		���� Ÿ���� �ټ� �߰ߵǸ�
		�ڵ����� �������� @Qualifier�� �ν��ؼ� �̸�(id)�� Ȯ��
	 */
	
	// @Autowired�� ����ϴ� ����
	/*
	@Inject
	@Qualifier(value="board1")
	private Board b1;
	
	@Inject
	@Qualifier(value="board2")
	private Board b2;
	*/
	
	
	
	///////////////////////////////////////////////////////////////////////////////////////////
	
	@Autowired
	private Notice notice1;
	
	@Autowired
	private Notice notice2;
	
	
	@GetMapping("notice/detail")
	public void noticeDetail() {
		System.out.println(notice1.getNoticeNo());
		System.out.println(notice1.getTitle());
		System.out.println(notice2.getNoticeNo());
		System.out.println(notice2.getTitle());
	}
	
	
}
