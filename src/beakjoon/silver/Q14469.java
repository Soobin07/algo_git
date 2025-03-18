package beakjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

public class Q14469 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[][] cows = new int[N][2];
		for (int i = 0; i < N; i++) {
			cows[i] = new int[] { sc.nextInt(), sc.nextInt() };
		}

		Arrays.sort(cows, (o1, o2) -> {
			if (o1[0] == o2[0]) {
				return o1[1] - o2[1];
			}
			return o1[0] - o2[0];
		});

		long sum = 0;
		int before = 0;
		for (int i = 0; i < N; i++) {
			if (before < cows[i][0]) {
				sum += (cows[i][0] - before);
				before = cows[i][0];
			}
			sum += cows[i][1];
			before += cows[i][1];
		}

		System.out.println(sum);
	}
}
