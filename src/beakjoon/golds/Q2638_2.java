package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2638_2 {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] map;
	static int N, M, ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		Queue<int[]> cheese = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					cheese.add(new int[] { i, j, 0 });
				}
			}
		}

		air_refrash();

		int max = 0;
		Queue<int[]> del = new LinkedList<>();
		while (!cheese.isEmpty()) {
			int[] tmp = cheese.poll();
			tmp[2]++;
			if (max < tmp[2]) {
				max = tmp[2];
				while (!del.isEmpty()) {
					int[] tmp2 = del.poll();
					map[tmp2[0]][tmp2[1]] = 0;
				}
				air_refrash();
			}
			int emt_cnt = 0;
			for (int i = 0; i < 4; i++) {
				int tmp_r = tmp[0] + dr[i];
				int tmp_c = tmp[1] + dc[i];
				if (tmp_r < 0 || tmp_r >= N || tmp_c < 0 || tmp_c >= M) {
					continue;
				}
				if (map[tmp[0] + dr[i]][tmp[1] + dc[i]] == -1) {
					emt_cnt++;
				}
			}
			if (emt_cnt < 2) {
				cheese.add(tmp);
			} else {
				del.add(tmp);
			}
		}
		System.out.println(max);

	}

	// 내부공기, 외부공기 구분 (외부공기 : -1, 내부공기 0)
	static void air_refrash() {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visit = new boolean[N][M];
		visit[0][0] = true;
		q.add(new int[] { 0, 0 });

		while (!q.isEmpty()) {
			int[] now = q.poll();
			map[now[0]][now[1]] = -1;

			// 사방 보고 주변 공기 외부공기 인식
			for (int i = 0; i < 4; i++) {
				int now_r = now[0] + dr[i];
				int now_c = now[1] + dc[i];

				// 사방보는데 맵 넘어가면 패스하기
				if (now_r < 0 || now_r >= N || now_c < 0 || now_c >= M)
					continue;

				// 다음 공기 찾으러 가기
				if (map[now_r][now_c] != 1 && !visit[now_r][now_c]) {
					q.add(new int[] { now_r, now_c });
					visit[now_r][now_c] = true;
				}
			}
		}
	}
}
