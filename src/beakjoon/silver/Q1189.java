package beakjoon.silver;

import java.util.Scanner;

public class Q1189 {
	static int R, C, K, ans;
	static char[][] map;
	static boolean[][] visit;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		R = sc.nextInt();
		C = sc.nextInt();
		K = sc.nextInt();

		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = sc.next().toCharArray();
		}

		visit = new boolean[R][C];
		visit[R - 1][0] = true;

		dsp(R - 1, 0, 1);

		System.out.println(ans);
	}

	static void dsp(int r, int c, int k) {
		if (r == 0 && c == C - 1) {
			if (k == K)
				ans++;
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr < 0 || nr >= R || nc < 0 || nc >= C)
				continue;
			if (map[nr][nc] == 'T')
				continue;
			if (visit[nr][nc])
				continue;

			visit[nr][nc] = true;
			dsp(nr, nc, k + 1);
			visit[nr][nc] = false;
		}
	}
}
