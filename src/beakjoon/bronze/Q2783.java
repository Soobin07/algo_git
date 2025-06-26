package beakjoon.bronze;

import java.util.Scanner;

public class Q2783 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		int Y = sc.nextInt();

		int N = sc.nextInt();
		double COST = X * (1000.0 / Y);

		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			double tmp = x * (1000.0 / y);
			COST = Math.min(tmp, COST);
		}
		System.out.printf("%.2f", COST);
	}
}
