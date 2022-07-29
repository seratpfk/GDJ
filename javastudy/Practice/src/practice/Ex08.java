package practice;

public class Ex08 {

	public static void main(String[] args) {
		
		
		Watch w = new Watch(16, 15, 30);
		
		w.addHour(25);
		w.addMinute(61);
		w.addSecond(3615);
		
		w.see();

	}

}
