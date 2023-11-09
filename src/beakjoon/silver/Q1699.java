package beakjoon.silver;

import java.util.Scanner;

public class Q1699 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = i;
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j * j <= i; j++) {
				arr[i] = Math.min(arr[i], arr[i - j * j] + 1);
			}
		}
		System.out.println(arr[N]);
	}
}
