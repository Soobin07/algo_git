package beakjoon.silver;

import java.util.Scanner;

public class Q9625 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int[] dp = new int[K + 1];
		dp[1] = 1;
		for (int i = 2; i < K + 1; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		System.out.println(dp[K - 1] + " " + dp[K]);
	}
}
 