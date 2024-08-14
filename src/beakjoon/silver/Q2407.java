package beakjoon.silver;

import java.math.BigInteger;
import java.util.Scanner;

public class Q2407 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		// 파스칼의 삼각형 사용
		BigInteger[][] dp = new BigInteger[101][101];
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					dp[i][j] = new BigInteger("1");
				} else {
					dp[i][j] = dp[i - 1][j - 1].add(dp[i - 1][j]);
				}
			}
		}

		System.out.println(dp[n][m]);
	}
}
