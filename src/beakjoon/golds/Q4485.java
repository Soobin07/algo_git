package beakjoon.golds;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q4485 {
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		N = 0;
		int cnt = 0;
		map = new int[125][125];
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;

			// 넣기
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				for (int m = 0; m < N; m++) {
					map[n][m] = Integer.parseInt(st.nextToken());
				}
			}

			// 출력
			cnt++;
			bw.append("Problem " + cnt + ": " + dijkstra() + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	static int dijkstra() {
		PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);

		int[][] dist = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		q.offer(new int[] { 0, 0, map[0][0] });
		dist[0][0] = map[0][0];

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int r = tmp[0];
			int c = tmp[1];

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N)
					continue;
				if (dist[nr][nc] <= dist[r][c] + map[nr][nc])
					continue;
				dist[nr][nc] = dist[r][c] + map[nr][nc];
				q.offer(new int[] { nr, nc, dist[nr][nc] });
			}
		}

		return dist[N - 1][N - 1];
	}
}
