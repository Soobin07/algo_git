package beakjoon.bronze;

import java.util.Scanner;

//10부제
public class Q10797 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int day = sc.nextInt();
		int[] cars = new int[5];
		
		int alert = 0;
		for(int i = 0 ; i < 5 ; i++) {
			cars[i] = sc.nextInt();
			if(day == cars[i])
				alert++;
		}
		
		System.out.println(alert);
	}
}
