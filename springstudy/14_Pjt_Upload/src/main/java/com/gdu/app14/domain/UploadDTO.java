package com.gdu.app14.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UploadDTO {
	private int uploadNo;
	private String title;
	private String content;
	private Timestamp createDate;
	private Timestamp modifyDate;
	private int attachCnt; // 첨부갯수
	
	// upload.xml의 resultType="UploadDTO"의 select문에 있는 쿼리들은 UploadDTO에 모두 선언하여야 한다.
}
