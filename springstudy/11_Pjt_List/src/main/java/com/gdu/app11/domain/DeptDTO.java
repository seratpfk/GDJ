package com.gdu.app11.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DeptDTO {

	private int departmentId; // 이름을 줄이면 mybatis가 인식을 못함.
	private String departmentName;
	private int managerId;
	private int locationId;
	
}
