package com.gdu.app11.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmpDTO {

	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Date hireDate;
	private String jobId;
	private double salary;  // DB Employee 테이블의 dataType: NUMBER(8,2) <- 2는 소수점 자릿수를 의미함.
	private double commissionPct;
	private int managerId;
	private DeptDTO deptDTO; // DeptDTO와의 조인. DeptDTO의 모든 키를 불러올 수 있다? departmentId가 기본키라서?
}
