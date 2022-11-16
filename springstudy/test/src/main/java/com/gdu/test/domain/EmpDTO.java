package com.gdu.test.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmpDTO {
	private int employeeId;
	private double salary;
	private DeptDTO deptDTO;
}