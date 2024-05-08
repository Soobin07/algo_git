package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//벽 부수고 이동하기 2
public class Q14442 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		char[][] map = new char[N][M];
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
		q.add(new int[] { 0, 0, 0 }); // r, c, 부순 cnt
		cost[0][0][0] = 1;
		cost[1][0][0] = 1;
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int dest = cost[tmp[2]][tmp[0]][tmp[1]];

			for (int i = 0; i < 4; i++) {
				int r = tmp[0] + dr[i];
				int c = tmp[1] + dc[i];
				int cnt = tmp[2];

				if (r < 0 || c < 0 || r >= N || c >= M)
					continue;
				if (map[r][c] == '1') {
					cnt++;
					if (cnt > K)
						continue;
				}
				if (cost[cnt][r][c] <= dest + 1)
					continue;
				cost[cnt][r][c] = dest + 1;
				q.add(new int[] { r, c, cnt });
			}
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
