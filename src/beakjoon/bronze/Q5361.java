package beakjoon.bronze;

import java.util.Scanner;

public class Q5361 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double[] costs = { 350.34, 230.90, 190.55, 125.30, 180.90 };

		int TC = sc.nextInt();
		while (TC-- > 0) {
			double sum = 0D;
			for (int i = 0; i < 5; i++) {
				sum += costs[i] * sc.nextInt();
			}
			System.out.printf("$%.2f\n", sum);
		}
	}
}
