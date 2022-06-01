package beakjoon.bronze;

import java.util.Scanner;

public class Q2525 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int time = sc.nextInt();
		int min = sc.nextInt();
		
		int req_min = sc.nextInt();
		
		System.out.println((time+(min+req_min)/60)%24+" "+((min+req_min)%60));
	}
}
