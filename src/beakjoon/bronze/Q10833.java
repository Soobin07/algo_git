package beakjoon.bronze;

import java.util.Scanner;

public class Q10833 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int rem = 0;
		for(int i = 0 ; i< N ; i++) {
			int mem = sc.nextInt();
			int apple = sc.nextInt();
			
			rem += apple % mem;
		}
		System.out.println(rem);
	}
}
