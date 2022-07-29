package practice;

import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("몇 개 생성할까요? >>> ");
		int count = sc.nextInt();
		
		
		if(count < 1 || count > 100) {
			System.out.println("1~100 사이만 가능합니다.");
			return; 
		}
		
		
		int[] arr = new int[count];
		
		for(int i = 0; i < arr.length; i++) {
			int random = (int)(Math.random() * 100) + 1;
			if(exists(arr, i, random)) {
				i--;
				continue;
			}
			arr[i] = random;
		}
		
		for(int i = 0; i < arr.length; i++) {
			if(i != 0 && i % 10 == 0)
				System.out.println();
			System.out.print(arr[i] + "\t");
		}
		
	}
		
		
	public static boolean exists(int[] arr, int idx, int random) {
		
		for(int i = 0; i <= idx; i++)
			if(arr[i] == random)
				return true;
		
		return false;
		
	
	}	

}
