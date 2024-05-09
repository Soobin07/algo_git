package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//벽 부수고 이동하기 3
public class Q16933 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		char[][] map = new char[N][M];
		boolean[][][] visit = new boolean[K + 1][N][M];
		int[][][] cost = new int[K + 1][N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		for (int i = 0; i <= K; i++) {
			for (int j = 0; j < N; j++) {
				Arrays.fill(cost[i][j], Integer.MAX_VALUE);
			}
		}

		// 0,0 -> N-1, M-1
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 0, 0, 0, 1, 1 }); // r, c, 부순 cnt, day(1) / night(-1), dist
		for (int i = 0; i <= K; i++) {
			cost[i][0][0] = 1;
			visit[i][0][0] = true;
		}

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int dist = tmp[4];

			boolean addStay = false;
			for (int i = 0; i < 4; i++) {
				int cnt = tmp[2];
				int r = tmp[0] + dr[i];
				int c = tmp[1] + dc[i];

				// 맵 밖인가?
				if (r < 0 || c < 0 || r >= N || c >= M)
					continue;

				// 벽인가?
				if (map[r][c] == '1') {
					// 밤인가? => 벽 못넘어감
					if (tmp[3] != 1) {
						// 한번 기다려
						addStay = true;
						continue;
					}
					// 낮인가? => 벽 넘어감
					cnt++;
					// 벽 더 못뚫는데? => 이번 이동 없는걸로.
					if (cnt > K)
						continue;
				}
				// 안갔었나?
				if (visit[cnt][r][c])
					continue;

				cost[cnt][r][c] = Math.min(dist + 1, cost[cnt][r][c]);
				q.add(new int[] { r, c, cnt, tmp[3] * (-1), dist + 1 });
				visit[cnt][r][c] = true;
			}
			if (addStay)
				q.add(new int[] { tmp[0], tmp[1], tmp[2], tmp[3] * (-1), dist + 1 });
		}

		int ans = Integer.MAX_VALUE;
		for (int i = 0; i <= K; i++) {
			ans = Math.min(ans, cost[i][N - 1][M - 1]);
		}
		if (ans == Integer.MAX_VALUE)
			ans = -1;

		System.out.println(ans);
	}
}
