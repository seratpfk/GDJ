package ex04_method;

public class VendingMachine {
	
	String getcoffee(int money, int button) {
		
		String[] menu = {"아메리카노", "카페라떼"};
		
		return menu[button - 1] + " " + (money / 1000) + "잔";
	}

}
