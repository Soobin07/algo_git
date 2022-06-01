package beakjoon.silver;

import java.util.Scanner;

public class Q1012 {
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int M, N, K;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			M = sc.nextInt();
			N = sc.nextInt();
			map = new int[N][M];

			K = sc.nextInt();
			int m, n;
			for (int k = 0; k < K; k++) {
				m = sc.nextInt();
				n = sc.nextInt();
				map[n][m] = 1;
			}

			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (K != 0 && map[i][j] == 1) {
						findAnother(i, j);
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
		}
	}

	static void findAnother(int i, int j) {
		map[i][j] = 2;
		K--;

		for (int k = 0; k < 4; k++) {
			if (i + dr[k] >= 0 && i + dr[k] < N && j + dc[k] >= 0 && j + dc[k] < M && map[i + dr[k]][j + dc[k]] == 1) {
				map[i + dr[k]][j + dc[k]] = 2;
				findAnother(i+dr[k], j+dc[k]);
			}
		}
	}
}
