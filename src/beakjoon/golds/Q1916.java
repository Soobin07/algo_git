package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1916 {
	static int N;
	static boolean[] visit;
	static long[] dijkstra;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		long[][] map = new long[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j) {
					map[i][j] = 0;
					continue;
				}
				map[i][j] = Integer.MAX_VALUE;
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			map[r][c] = Math.min(map[r][c], v);
		}

		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		dijkstra = map[s].clone();
		visit = new boolean[N + 1];
		visit[s] = true;

		for (int i = 2; i <= N; i++) {
			int idx = sel();
			visit[idx] = true;
			for (int j = 1; j <= N; j++) {
				if (!visit[j])
					dijkstra[j] = Math.min(dijkstra[j], dijkstra[idx] + map[idx][j]);
			}
		}
		System.out.println(dijkstra[e]);
	}

	static int sel() {
		int min_i = 0;
		long min = Integer.MAX_VALUE;

		for (int i = 1; i <= N; i++) {
			if (visit[i])
				continue;
			if (min > dijkstra[i]) {
				min = dijkstra[i];
				min_i = i;
			}
		}

		return min_i;
	}
}
