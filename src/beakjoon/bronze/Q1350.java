package beakjoon.bronze;

import java.util.Scanner;

public class Q1350 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] files = new int[N];
		for (int i = 0; i < N; i++) {
			files[i] = sc.nextInt();
		}

		int cluster = sc.nextInt();
		long sum = 0;
		for (int i = 0; i < N; i++) {
			sum += (Math.ceil(1.0 * files[i] / cluster)) * cluster;
		}

		System.out.println(sum);
	}
}
