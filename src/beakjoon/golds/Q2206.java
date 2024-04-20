package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//벽 부수고 이동하기 
public class Q2206 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int[][][] cost = new int[2][N][M]; // 0: 벽부수지X, 1:벽 부순 후

		// map 넣기
		// 1 : 벽, 0 : 이동가능
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
			Arrays.fill(cost[0][i], Integer.MAX_VALUE);
			Arrays.fill(cost[1][i], Integer.MAX_VALUE);
		}

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		// 0,0에서 N-1,M-1로 가자
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 0, 0, 0, 1 }); // r, c, 벽, 걸어간 숫자
		cost[0][0][0] = 1;

		while (!q.isEmpty()) {
			int[] now = q.poll();
			// 상하좌우 확인
			for (int i = 0; i < 4; i++) {
				int r = dr[i] + now[0];
				int c = dc[i] + now[1];
				int wall = now[2];
				// 맵 밖이면 취소
				if (r >= N || c >= M || r < 0 || c < 0)
					continue;
				// 위치가 벽이면
				if (map[r][c] == 1) {
					// 이미 벽 부쉈으면 취소
					if (wall == 1)
						continue;
					wall += 1;
				}
				// 이미 얘보다 더 가까운 애가 있으면 취소
				if (cost[wall][r][c] <= now[3] + 1)
					continue;

				// 큐에 넣기
				cost[wall][r][c] = now[3] + 1;
				q.add(new int[] { r, c, wall, now[3] + 1 });
			}
		}

		// 둘중 더 작은거 뽑기
		int ans = Math.min(cost[0][N - 1][M - 1], cost[1][N - 1][M - 1]);
		if (ans == Integer.MAX_VALUE)
			ans = -1;
		System.out.println(ans);
	}
}
