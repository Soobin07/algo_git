package beakjoon.bronze;

import java.util.Scanner;

public class Q10811 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] baskets = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			baskets[i] = i;
		}

		// 바꾸기
		for (int i = 0; i < M; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int[] tmp = new int[end - start + 1];
			for (int j = start; j <= end; j++) {
				tmp[end - j] = baskets[j];
			}
			for (int j = 0; j < tmp.length; j++) {
				baskets[j + start] = tmp[j];
			}
		}

		// 출력
		for (int i = 1; i < N + 1; i++) {
			System.out.print(baskets[i] + " ");
		}
	}
}
