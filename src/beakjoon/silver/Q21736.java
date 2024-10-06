package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//헌내기는 친구가 필요해
public class Q21736 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] map = new char[N][M];
		int[] doyon = { 0, 0 };
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = tmp.charAt(j);
				if (map[i][j] == 'I') {
					doyon[0] = i;
					doyon[1] = j;
				}
			}
		}

		Queue<int[]> q = new LinkedList<>();
		q.add(doyon);

		int[] dr = { 1, -1, 0, 0 };
		int[] dc = { 0, 0, 1, -1 };

		boolean[][] visit = new boolean[N][M];
		visit[doyon[0]][doyon[1]] = true;

		int ans = 0;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			for (int d = 0; d < 4; d++) {
				int[] next = { now[0] + dr[d], now[1] + dc[d] };
				if (next[0] < 0 || next[0] >= N || next[1] < 0 || next[1] >= M)
					continue;
				if (map[next[0]][next[1]] == 'X')
					continue;
				if (visit[next[0]][next[1]])
					continue;

				visit[next[0]][next[1]] = true;
				q.add(next);
				if (map[next[0]][next[1]] == 'P')
					ans++;
			}
		}

		System.out.println(ans == 0 ? "TT" : ans);
	}
}
