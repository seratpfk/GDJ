package com.gdu.app01.xml08;

public class BMICaculator {

	private Calculator calc;
	private double height;
	private double weight;
	private double bmi;
	private String health;
	
	public BMICaculator(Calculator calc, double height, double weight) { // bmi, health 삭제
		super();
		this.calc = calc;
		this.height = height;
		this.weight = weight;
		bmi = calc.div(weight, calc.div(calc.mul(height, height), 10000));
		health = (bmi < 20) ? "저체중" : (bmi < 25) ? "정상" : (bmi < 30) ? "과체중" : "비만";
	}
	
	public void info() {
		System.out.println("BMI: " + bmi);
		System.out.println("Health: " + health);
	}
}
