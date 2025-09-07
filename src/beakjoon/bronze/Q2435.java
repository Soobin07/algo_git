package beakjoon.bronze;

import java.util.Scanner;

public class Q2435 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		int[] temp = new int[N];
		for (int i = 0; i < N; i++) {
			temp[i] = sc.nextInt();
		}
		int[] arr = new int[N + 1];
		for (int i = 0; i < N; i++) {
			arr[i + 1] = arr[i] + temp[i];
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i <= N - K; i++) {
			int sum = arr[i + K] - arr[i];
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}
}
