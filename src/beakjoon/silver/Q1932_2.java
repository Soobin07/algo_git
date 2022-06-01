package beakjoon.silver;

import java.util.Scanner;

public class Q1932_2 {
	static int N;
	static int[][] map, dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[501][501];
		dp = new int[501][501];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i + 1; j++) {
				map[i][j] = sc.nextInt();
			}
		} // 삼각형 넣기

		dp[0][0] = map[0][0]; // 맨 윗칸 채우기
		dp[1][0] = dp[0][0] + map[1][0];// 두번째줄 왼쪽칸
		dp[1][1] = dp[0][0] + map[1][1];// 두번째줄 오른쪽칸

		for (int i = 2; i < N; i++) { // 아래칸부터 누적합
			dp[i][0] = dp[i - 1][0] + map[i][0];
			for (int j = 1; j < i; j++) {// 최대값 찾을 칸 찾기
				dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + map[i][j]; // 위 왼쪽, 오른쪽중 max값 찾기
			}
			dp[i][i] = dp[i - 1][i - 1] + map[i][i];
		}

		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, dp[N - 1][i]);
		}
		System.out.println(max);
	}
}
