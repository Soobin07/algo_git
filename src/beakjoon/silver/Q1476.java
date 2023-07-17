package beakjoon.silver;

import java.util.Scanner;

public class Q1476 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int E = sc.nextInt();
		int S = sc.nextInt();
		int M = sc.nextInt();
		
		int max = Math.max(E, Math.max(S, M));
		int year = max;
		while(true) {
			if((year-E) % 15 == 0 && (year-S) % 28 == 0 && (year-M) % 19 == 0) {
				break;
			}
			year++;
		}
		System.out.println(year);
	}
}
