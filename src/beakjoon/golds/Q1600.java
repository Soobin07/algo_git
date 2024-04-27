package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//말이 되고픈 원숭이
public class Q1600 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		// map 넣기
		int[][] map = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][][] costs = new int[K + 1][H][W];
		for (int k = 0; k <= K; k++) {
			for (int h = 0; h < H; h++) {
				Arrays.fill(costs[k][h], 40000);
			}
		}

		int ans = 40000;

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		int[] drh = { -2, -1, 1, 2, -2, -1, 1, 2 };
		int[] dch = { -1, -2, -2, -1, 1, 2, 2, 1 };

		int[] dist = { H - 1, W - 1 };
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 0, 0, 0, 0 }); // r, c, jump_cnt, cost
		costs[0][0][0] = 0;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			// 기본부터
			for (int d = 0; d < 4; d++) {
				int r = now[0] + dr[d];
				int c = now[1] + dc[d];
				// 밖 나가면 끝
				if (r >= H || c >= W || r < 0 || c < 0)
					continue;
				// 장애물 있으면 끝
				if (map[r][c] == 1)
					continue;
				// 만약 얘 위치에 얘보다 빨리 도착한 애 있으면 끝
				if (costs[now[2]][r][c] <= now[3] + 1)
					continue;

				// Q에 넣기
				q.add(new int[] { r, c, now[2], now[3] + 1 });
				costs[now[2]][r][c] = now[3] + 1;
			}
			// jump 더 할 수 있으면
			if (now[2] < K) {
				for (int d = 0; d < 8; d++) {
					int r = now[0] + drh[d];
					int c = now[1] + dch[d];
					// 밖 나가면 끝
					if (r >= H || c >= W || r < 0 || c < 0)
						continue;
					// 장애물 있으면 끝
					if (map[r][c] == 1)
						continue;
					// 만약 얘 위치에 얘보다 빨리 도착한 애 있으면 끝
					if (costs[now[2] + 1][r][c] <= now[3] + 1)
						continue;

					// Q에 넣기
					q.add(new int[] { r, c, now[2] + 1, now[3] + 1 });
					costs[now[2] + 1][r][c] = now[3] + 1;
				}
			}
		}

		for (int k = 0; k <= K; k++) {
			ans = Math.min(ans, costs[k][H - 1][W - 1]);
		}
		if (ans == 40000)
			ans = -1;
		System.out.println(ans);
	}
}
