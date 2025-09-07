package beakjoon.bronze;

import java.util.Scanner;

public class Q25704 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int P = sc.nextInt();

		int min = P;
		if (N / 5 >= 1) {
			min = Math.min(min, Math.max(P - 500, 0));
		}
		if (N / 5 >= 2) {
			min = Math.min(min, P * 9 / 10);
		}
		if (N / 5 >= 3) {
			min = Math.min(min, Math.max(P - 2000, 0));
		}
		if (N / 5 >= 4) {
			min = Math.min(min, P * 3 / 4);
		}

		System.out.println(min);
	}
}
