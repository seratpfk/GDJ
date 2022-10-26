package com.gdu.app01.xml02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("xml02/appCtx.xml");
		Car car = ctx.getBean("dreamCar", Car.class); 
		
		System.out.println(car.getModel());
		System.out.println(car.getMaker());
		Engine engine = car.getEngine();
		System.out.println(engine.getFuel());
		System.out.println(engine.getEfficency());
		System.out.println(engine.getCc());
		
		ctx.close();

	}

}
