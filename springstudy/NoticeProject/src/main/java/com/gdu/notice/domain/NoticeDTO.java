package com.gdu.notice.domain;

import java.sql.Timestamp;

public class NoticeDTO {

	private int noticeNo;
	private String title;
	private String content;
	private int hit;
	private Timestamp createDate;
	private Timestamp modifyDate;
	
	// @NoArgsConstructor
	public NoticeDTO() {
		// TODO Auto-generated constructor stub
	}
	public NoticeDTO(int noticeNo, String title, String content, int hit, Timestamp createDate, Timestamp modifyDate) {
		super();
		this.noticeNo = noticeNo;
		this.title = title;
		this.content = content;
		this.hit = hit;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
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

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}
	
	
	
}
