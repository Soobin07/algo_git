package beakjoon.bronze;

import java.util.Scanner;

public class Q10870 {
	public static void main(String[] args) {
		//피보나치 수열
		//before을 담아두고, 현재 수를 before에 담는 것이 포인트였다.
		
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int before = 0;
		int number = 1;
		
		if(count == 0) {
			System.out.println(0); return;
		}else if(count == 1) {
			System.out.println(1); return; 
		}
		for(int i = 1 ; i < count ; i++) {
			int temp = before;
			before = number;
			number = temp+number;
		}
		System.out.println(number);
	}
}
