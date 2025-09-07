package beakjoon.bronze;

import java.util.Scanner;

public class Q22864 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int M = sc.nextInt();

		int tired = 0;
		int sum = 0;
		for (int i = 0; i < 24; i++) {
			if (tired + A <= M) {
				tired += A;
				sum += B;
			} else {
				tired = Math.max(tired - C, 0);
			}
		}

		System.out.println(sum);
	}
}
