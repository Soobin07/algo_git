package beakjoon.bronze;

import java.util.Scanner;

public class Q13136 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long R = sc.nextInt();
		long C = sc.nextInt();
		double N = sc.nextInt();

		System.out.println((long) Math.ceil(R / N) * (long) Math.ceil(C / N));
	}
}
