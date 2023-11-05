package beakjoon.bronze;

import java.util.Scanner;

public class Q10813 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] bas = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			bas[i] = i;
		}

		for (int i = 0; i < M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			int tmp = bas[A];
			bas[A] = bas[B];
			bas[B] = tmp;
		}

		for (int i = 1; i < N + 1; i++) {
			System.out.print(bas[i] + " ");
		}
	}
}
