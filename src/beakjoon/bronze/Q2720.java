package beakjoon.bronze;

import java.util.Scanner;

public class Q2720 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] coins = { 25, 10, 5, 1 };

		for (int t = 0; t < T; t++) {
			int[] ans = new int[4];
			int c = sc.nextInt();
			for (int i = 0; i < 4; i++) {
				ans[i] = c / coins[i];
				c %= coins[i];
				if (c == 0)
					break;
			}

			for (int k = 0; k < 4; k++) {
				System.out.print(ans[k] + " ");
			}
			System.out.println();
		}

	}
}
