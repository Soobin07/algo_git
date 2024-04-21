package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//NM과 K (1)
public class Q18290 {
	static int[][] map;
	static boolean[][] visit;
	static int N, M, K, ans;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// NxM 격자판
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		ans = Integer.MIN_VALUE;

		// map 넣기
		map = new int[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		choose(0, 0, 0, 0);
		System.out.println(ans);
	}

	static void choose(int sel_idx, int r, int c, int sum) {
		if (sel_idx == K) {
			ans = Math.max(ans, sum);
			return;
		}
		if (r == N && c == M)
			return;

		for (int i = r; i < N; i++) {
			for (int j = (i == r ? c : 0); j < M; j++) {
				// 안간곳임
				if (visit[i][j])
					continue;
				// 있는것의 상하좌우 아님
				if (!isOK(i, j))
					continue;

				// 업데이트
				visit[i][j] = true;
				choose(sel_idx + 1, i, j, sum + map[i][j]);
				visit[i][j] = false;
			}
		}
	}

	static boolean isOK(int r, int c) {
		for (int i = 0; i < 4; i++) {
			if (r + dr[i] >= N || c + dc[i] >= M || r + dr[i] < 0 || c + dc[i] < 0)
				continue;
			if (visit[r + dr[i]][c + dc[i]])
				return false;
		}
		return true;
	}
}
