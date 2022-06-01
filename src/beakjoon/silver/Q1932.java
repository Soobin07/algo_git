package beakjoon.silver;

import java.util.Scanner;

//시간초과
public class Q1932 {
	static int N;
	static int[][] map;
	static int[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][];
		for (int i = 0; i < N; i++) {
			map[i] = new int[i + 1];
			for (int j = 0; j < i + 1; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		dp = new int[N];
		dp[0] = map[0][0]; // 값
		findMax(0, 0, dp[0]);

		System.out.println(dp[N - 1]);
	}

	private static void findMax(int row, int idx, int sum) {
		if (row == N - 1)
			return; // 종료

		// 왼쪽 아래 확인
		int left = map[row + 1][idx];
		// 오른쪽 아래 확인
		int right = map[row + 1][idx + 1];

		// 둘중 큰 것 실어서 아래로
		if (dp[row + 1] <= sum + left) {
			dp[row + 1] = sum + left;
		}
		findMax(row + 1, idx, sum + left);

		if (dp[row + 1] <= sum + right) {
			dp[row + 1] = sum + right;
		}
		findMax(row + 1, idx + 1, sum + right);
	}
}
