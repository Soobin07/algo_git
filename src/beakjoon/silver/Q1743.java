package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//음식물 피하기
public class Q1743 {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visit;
	static int[][] map;
	static int N, M, K;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// 통로 세로, 가로길이, 쓰레기 개수
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로
		K = Integer.parseInt(st.nextToken()); // 쓰레기 개수

		// 쓰레기 떨어진 좌표
		map = new int[N + 1][M + 1];
		visit = new boolean[N + 1][M + 1];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
		}

		// 시작 좌표
		int max = 0;
		for (int n = 1; n <= N; n++) {
			for (int m = 1; m <= M; m++) {
				max = Math.max(max, find(n, m));
			}
		}

		System.out.println(max);
	}

	static int find(int n, int m) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { n, m });

		int cnt = 0;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			// 현재 위치 확인
			if (map[now[0]][now[1]] != 1)
				continue;
			// 4방 확인
			for (int d = 0; d < 4; d++) {
				int r = now[0] + dr[d];
				int c = now[1] + dc[d];

				// 맵 밖이면 넘어가기
				if (r <= 0 || c <= 0 || r > N || c > M)
					continue;

				// 이미 왔다 갔으면 넘어가기
				if (visit[r][c])
					continue;

				// 쓰레기 없으면 넘어가기
				if (map[r][c] != 1)
					continue;

				visit[r][c] = true;
				cnt++;
				q.add(new int[] { r, c });
			}
		}

		return cnt;
	}
}
