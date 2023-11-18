package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2174 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] robot = new int[N + 1][3];
		int[] dr = { 1, 0, -1, 0 }; // ENWS
		int[] dc = { 0, 1, 0, -1 };
		int[][] map = new int[A + 1][B + 1];

		for (int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			robot[n] = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0 };
			map[robot[n][0]][robot[n][1]] = n;
			int tmp_dir = 0;
			String tmp = st.nextToken();
			if (tmp.equals("N")) {
				tmp_dir = 1;
			} else if (tmp.equals("W")) {
				tmp_dir = 2;
			} else if (tmp.equals("S")) {
				tmp_dir = 3;
			}
			robot[n][2] = tmp_dir;
		}

		boolean flag = true;
		comm: for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(st.nextToken());
			String com = st.nextToken();
			int R = Integer.parseInt(st.nextToken());

			if (com.equals("L")) {
				robot[b][2] += R;
				robot[b][2] %= 4;
			} else if (com.equals("R")) {
				R %= 4;
				robot[b][2] += (-1 * R + 4);
				robot[b][2] %= 4;
			} else {
				map[robot[b][0]][robot[b][1]] = 0;
				for (int r = 0; r < R; r++) {
					robot[b][0] += dr[robot[b][2]];
					robot[b][1] += dc[robot[b][2]];
					if (robot[b][0] <= 0 || robot[b][0] > A || robot[b][1] <= 0 || robot[b][1] > B) {
						System.out.println("Robot " + b + " crashes into the wall");
						flag = false;
						break comm;
					}
					if (map[robot[b][0]][robot[b][1]] != 0) {
						System.out.println("Robot " + b + " crashes into robot " + map[robot[b][0]][robot[b][1]]);
						flag = false;
						break comm;
					}
				}
				map[robot[b][0]][robot[b][1]] = b;
			}
		}
		if (flag) {
			System.out.println("OK");
		}
	}
}
