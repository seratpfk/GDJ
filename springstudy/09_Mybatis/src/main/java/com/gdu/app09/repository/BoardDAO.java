package com.gdu.app09.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gdu.app09.domain.BoardDTO;

@Repository  // 컴포넌트로 등록
public class BoardDAO {

	// SqlSessionTemplete
	// Mybatis에서 지원하는 매퍼 처리 클래스
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<BoardDTO> selectAllBoards() {
		return sqlSessionTemplate.selectList("mybatis.mapper.board.selectAllBoards"); // mapper namespace
	}
	
	public BoardDTO selectBoardByNo(int boardNo) {  // public BoardDTO(리턴타입) selectBoardByNo(메소드이름)
		
		return sqlSessionTemplate.selectOne("mybatis.mapper.board.selectBoardByNo", boardNo);
	}
	
	public int insertBoard(BoardDTO board) {

		return sqlSessionTemplate.insert("mybatis.mapper.board.insertBoard", board); // mapper + id
	}
	
	public int updateBoard(BoardDTO board) {
	       return sqlSessionTemplate.update("mybatis.mapper.board.updateBoard", board);
	     }
	   
    public int deleteBoard(int boardNo) {
       return sqlSessionTemplate.delete("mybatis.mapper.board.deleteBoard", boardNo);
    }

	
	
}