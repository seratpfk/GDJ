package com.gdu.app01.xml01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMain {

	public static void main(String[] args) {
		
		// ���� ������
		// �����ڰ� Bean�� �������.
		// Calculator calculator = new Calculator();
		
		// ���ο� �����ӿ�ũ
		// �����ӿ�ũ�� ���� Bean�� ������ ����.
		
		// XML�� ����� Bean �������� Ŭ����
		// GenericXmlApplicationContext
		// ClassPathXmlApplicationContext
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:xml01/appCtx.xml");
		Calculator calculator = ctx.getBean("calc", Calculator.class);
		calculator.add(5, 2);
		calculator.sub(5, 2);
		calculator.mul(5, 2);
		calculator.div(5, 2);
		
		Student student = ctx.getBean("haksang", Student.class); // Student student = (Student)ctx.getBean("haksang");
		System.out.println(student.getName());
		System.out.println(student.getSchool());
		student.getCalculator().add(7, 3);
		student.getCalculator().sub(7, 3);
		student.getCalculator().mul(7, 3);
		student.getCalculator().div(7, 3);

		ctx.close();

	}

}
