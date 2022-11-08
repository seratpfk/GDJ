package com.gdu.app10.domain;

public class BoardDTO {

   private int boardNo;
   private String title, content, writer, createDate, modifyDate;
   
   public BoardDTO() {

   }

public BoardDTO(int boardNo, String title, String content, String writer, String createDate, String modifyDate) {
	super();
	this.boardNo = boardNo;
	this.title = title;
	this.content = content;
	this.writer = writer;
	this.createDate = createDate;
	this.modifyDate = modifyDate;
}

public int getBoardNo() {
	return boardNo;
}

public void setBoardNo(int boardNo) {
	this.boardNo = boardNo;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getContent() {
	return content;
}

public void setContent(String content) {
	this.content = content;
}

public String getWriter() {
	return writer;
}

public void setWriter(String writer) {
	this.writer = writer;
}

public String getCreateDate() {
	return createDate;
}

public void setCreateDate(String createDate) {
	this.createDate = createDate;
}

public String getModifyDate() {
	return modifyDate;
}

public void setModifyDate(String modifyDate) {
	this.modifyDate = modifyDate;
}
   
   

  



   
}
