package com.gdu.app13.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
	private Long userNo;
	private String id;
	private String pw;
	private String name;
	private String gender;
	private String email;
	private String mobile;
	private String birthyear;
	private String birthday;
	// 주소
	private String postcode;
	private String roadAddress;
	private String jibunAddress;
	private String detailAddress;
	private String extraAddress;
	
	private Integer agreeCode;  // 약관 동의. null값이 필요하기 때문에 Integer로 저장
	private String snsType;
	private Date joinDate;
	private Date pwModifyDate;
	private Date infoModifyDate;
	private String sessionId;
	private Date sessionLimitDate;
}
