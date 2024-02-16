package beakjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q14940 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] map = new int[n][m];
		int[][] dist = new int[n][m];
		boolean[][] visit = new boolean[n][m];

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		// dist 초기화
		for (int i = 0; i < n; i++) {
			Arrays.fill(dist[i], -1);
		}

		// 갈 수 있는 점 넣기
		Queue<int[]> q = new LinkedList<>();

		// map넣으면서 도착점 찾기
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					q.add(new int[] { i, j });
					visit[i][j] = true;
					dist[i][j] = 0;
				} else if (map[i][j] == 0) {
					dist[i][j] = 0;
				}
			}
		}

		// 도착점에서 움직이면서 거리 확인
		while (!q.isEmpty()) {
			int[] now = q.poll();
			// 4방위
			for (int i = 0; i < 4; i++) {
				int r = now[0] + dr[i];
				int c = now[1] + dc[i];
				// 맵 벗어나는지 확인
				if (r < 0 || r >= n || c < 0 || c >= m)
					continue;
				// 이미 갔는지 확인
				if (visit[r][c])
					continue;
				// 갈 수 있는 곳인지 확인
				if (map[r][c] == 0)
					continue;

				// 거리 넣어주기
				dist[r][c] = dist[now[0]][now[1]] + 1;
				// 방문확인
				visit[r][c] = true;
				// 여기서 다시 시작
				q.add(new int[] { r, c });
			}
		}

		//출력
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				bw.append(dist[i][j] + " ");
			}
			bw.append("\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
