package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q11967 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<int[]>[][] switchs = new ArrayList[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				switchs[i][j] = new ArrayList<int[]>();
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			switchs[x][y].add(new int[] { a, b });
		}

		boolean[][] visit = new boolean[N + 1][N + 1];
		boolean[][] light = new boolean[N + 1][N + 1];

		int cnt = 1;

		// 현재 불 켜짐 + 갈 수 있음
		Queue<int[]> q = new LinkedList<>();

		q.add(new int[] { 1, 1 });
		light[1][1] = true;
		visit[1][1] = true;

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		while (!q.isEmpty()) {
			int[] now = q.poll();

			// 해당 방에서 켤 수 있는 스위치가 있으면 새로운 길 넣는다
			if (!switchs[now[0]][now[1]].isEmpty()) {
				// 매번 초기화 (새로운 길 열려있을 수 있음)
				visit = new boolean[N + 1][N + 1];
				visit[now[0]][now[1]] = true;

				// 지금 여기서 불 킬 수 있는거 다 킨다
				for (int[] next : switchs[now[0]][now[1]]) {
					// 불 켜져있으면 패스
					if (light[next[0]][next[1]])
						continue;

					light[next[0]][next[1]] = true;
					cnt++;
				}
				// now의 불 사용 완료
				switchs[now[0]][now[1]].clear();
			}

			// 현재 위치에서 사방을 본다 (다음 갈 길)
			for (int d = 0; d < 4; d++) {
				int r = now[0] + dr[d];
				int c = now[1] + dc[d];

				// 맵 벗어나면 아웃
				if (r <= 0 || c <= 0 || r > N || c > N)
					continue;

				// 이미 가본 곳이면 넘어감
				if (visit[r][c])
					continue;

				// 갈 수 있는 (불 켜져있는) 곳이 있으면 넣는다
				if (light[r][c]) {
					q.add(new int[] { r, c });
					visit[r][c] = true;
				}
			}
		}

		System.out.println(cnt);
	}
}
