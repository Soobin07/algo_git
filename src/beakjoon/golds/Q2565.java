package beakjoon.golds;

import java.util.Arrays;
import java.util.Scanner;

public class Q2565 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[][] cables = new int[n][2];
		for (int i = 0; i < n; i++) {
			cables[i][0] = sc.nextInt();
			cables[i][1] = sc.nextInt();
		}

		Arrays.sort(cables, (a, b) -> {
			if (a[0] == b[0])
				return a[1] - b[1];
			return a[0] - b[0];
		});

		int[] dp = new int[n];
		Arrays.fill(dp, 1); // 각 전깃줄은 최소 자기 자신만 포함

		int maxLIS = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (cables[j][1] < cables[i][1]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			maxLIS = Math.max(maxLIS, dp[i]);
		}

		System.out.println(n - maxLIS);
	}
}
