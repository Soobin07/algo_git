package beakjoon.silver;

import java.util.Scanner;

public class Q10157 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		int R = sc.nextInt();

		long K = sc.nextLong();
		if (C * R < K) {
			System.out.println(0);
			return;
		} else if (K == 1) {
			System.out.println(1 + " " + 1);
			return;
		}

		long[][] map = new long[R][C];
		int c = 0;
		int r = R - 1;
		int dir = 0;
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		map[r][c] = 1;
		for (int i = 2; i <= C * R; i++) {
			int tc = c + dc[dir];
			int tr = r + dr[dir];
			if (tc < 0 || tc >= C || tr < 0 || tr >= R || map[tr][tc] != 0) {
				dir += 1;
				dir %= 4;
				i--;
				continue;
			}

			if (i == K) {
				System.out.println((tc + 1) + " " + (R - tr));
				return;
			}

			map[tr][tc] = i;
			c = tc;
			r = tr;
		}
	}
}
