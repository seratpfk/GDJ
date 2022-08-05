package parking;

import java.util.Scanner;

public class ParkingLot {
	
	private String name;
	private Car[] cars;
	private int idx;
	private Scanner sc;
	
	
	
	public ParkingLot(String name) {
		this.name = name;
		sc = new Scanner(System.in);
		cars = new Car[10];
	}
	
	
	
	private void addCar() {
		if(idx == cars.length) {
			System.out.println("더 이상 차량 등록이 불가능합니다.");
			return;
		}
		System.out.println("현재 등록된 차량 " + idx + "대");
		System.out.println("차량번호 >>> ");
		String carNo = sc.next();
		System.out.println("모델 >>> ");
		String model = sc.next();
		Car car = new Car(carNo, model);
		cars[idx++] = car;
		System.out.println("차량번호 " + carNo + " 차량이 등록되었습니다.");
	}
	
	private void deleteCar() {
		if(idx == 0) {
			System.out.println("등록된 차량이 없습니다.");
			return;
		}
		System.out.println("제거할 차량번호 >>> ");
		String carNo = sc.next();
		for(int i = 0; i < idx; i++) {
			if(carNo.equals(cars[i].getCarNo())) {
				System.arraycopy(cars, i + 1, cars, i, idx - i - 1);
				cars[--idx] = null;
				System.out.println("차량번호 " + carNo + " 차량이 삭제되었습니다.");
				return;
			}
		}
		System.out.println("대상 차량이 존재하지 않습니다.");
		
	}
	
	private void printAllCars() {
		System.out.println(name + " 차량 목록");
		if(idx == 0) {
			System.out.println("등록된 차량이 없습니다.");
			return;
		}
		for(int i = 0; i < idx; i++) {
			System.out.println(cars[i]);
		}
	}
	
	public void manage() {
		while(true) {
			System.out.println("1.추가 2.삭제 3.전체 0.종료 >>> ");
			int choice = sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1: addCar(); break;
			case 2: deleteCar(); break;
			case 3: printAllCars(); break;
			case 0: System.out.println("ParkingLot 프로그램을 종료합니다. 감사합니다.");
					return;	
			default: System.out.println("존재하지 않는 메뉴입니다.");
			}
		}
	}

}
