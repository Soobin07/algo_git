package beakjoon.golds;

import java.util.Scanner;

public class Q2447 {
	static boolean[][][] map;
	static int N;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		N = sc.nextInt();

		map = new boolean[8][][];
		map[0] = new boolean[1][1];
		map[0][0][0] = true;

		make(0, 1);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(map[ans][i][j] ? '*' : ' ');
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	static void make(int cnt, int n) {
		if (n >= N) {
			ans = cnt;
			return;
		}
		map[cnt + 1] = new boolean[n * 3][n * 3];

		for (int i = 0; i < n * 3; i += n) {
			for (int j = 0; j < n * 3; j += n) {
				if (i / n == 1 && j / n == 1)
					continue;
				for (int i2 = 0; i2 < n; i2++) {
					for (int j2 = 0; j2 < n; j2++) {
						map[cnt + 1][i + i2][j + j2] = map[cnt][i2][j2];
					}
				}
			}
		}
		make(cnt + 1, n * 3);
	}
}
