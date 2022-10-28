package com.gdu.app01.xml08;

import java.util.List;

public class Member {

	private String name;
	private List<String> course;
	private double height;
	private double weight;
	private BMICaculator bmiCalc;
	
	public Member(String name, List<String> course, double height, double weight, BMICaculator bmiCalc) {
		super();
		this.name = name;
		this.course = course;
		this.height = height;
		this.weight = weight;
		this.bmiCalc = bmiCalc;
	}
	
	public void info() {
		System.out.println("Name: " + name);
		for(String str : course) {
			System.out.println("Course: " + str);
		}
		System.out.println("Height: " + height);
		System.out.println("Weight: " + weight);
		bmiCalc.info();
	}
	
}
