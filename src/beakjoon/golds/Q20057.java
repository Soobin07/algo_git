package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q20057 {
	static int N, out;
	static int[][] map;
	static int[][] dr, dc;
	static double[] rate;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dr = new int[4][];
		dc = new int[4][];
		rate = new double[] { 0.02, 0.1, 0.07, 0.01, 0.05, 0.1, 0.07, 0.01, 0.02 };
		// 좌 (y, 흩날리는곳, a)
		dr[0] = new int[] { 0, -2, -1, -1, -1, 0, 1, 1, 1, 2, 0 };
		dc[0] = new int[] { -1, -1, -2, -1, 0, -3, -2, -1, 0, -1, -2 };
		// 하
		dr[1] = new int[] { 1, 1, 2, 1, 0, 3, 2, 1, 0, 1, 2 };
		dc[1] = new int[] { 0, -2, -1, -1, -1, 0, 1, 1, 1, 2, 0 };
		// 우
		dr[2] = new int[] { 0, 2, 1, 1, 1, 0, -1, -1, -1, -2, 0 };
		dc[2] = new int[] { 1, 1, 2, 1, 0, 3, 2, 1, 0, 1, 2 };
		// 상
		dr[3] = new int[] { -1, -1, -2, -1, 0, -3, -2, -1, 0, -1, -2 };
		dc[3] = new int[] { 0, 2, 1, 1, 1, 0, -1, -1, -1, -2, 0 };

		storm();

		System.out.println(out);
	}

	public static void storm() {
		int r = N / 2;
		int c = N / 2;
		int time = 1;
		int dir = 0;

		// 좌하우상
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { -1, 0, 1, 0 };

		while (r != 0 || c != 0) {
			for (int t = 0; t < time; t++) {
//				print_map(r, c, dir);
				move(r, c, dir);

				r += dr[dir];
				c += dc[dir];

				if (r == 0 && c == 0)
					return;
			}

			if (dir % 2 == 1)
				time++;
			dir += 1;
			dir %= 4;
		}
	}

	public static void print_map(int r, int c, int dir) {
		System.out.println("============================");
		System.out.println("[ " + r + " , " + c + " ] " + "dir : " + dir);
		System.out.println("============================");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("out : " + out);
		System.out.println("============================");
	}

	public static void move(int r, int c, int dir) {
		int ori = map[r + dr[dir][0]][c + dc[dir][0]];
		map[r + dr[dir][0]][c + dc[dir][0]] = 0;
		int used = 0;
		for (int i = 1; i < dr[dir].length - 1; i++) {
			int cr = r + dr[dir][i];
			int cc = c + dc[dir][i];
			int dust = (int) (ori * rate[i - 1]);
			used += dust;
			if (cr >= N || cc >= N || cr < 0 || cc < 0) {
				out += dust;
				continue;
			}
			map[cr][cc] += dust;
		}

		int cr = r + dr[dir][10];
		int cc = c + dc[dir][10];
		int dust = ori - used;
		if (cr >= N || cc >= N || cr < 0 || cc < 0) {
			out += dust;
		} else {
			map[r + dr[dir][10]][c + dc[dir][10]] += dust;
		}
	}
}
