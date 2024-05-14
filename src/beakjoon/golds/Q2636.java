package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//치즈
public class Q2636 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int[][] cheese = new int[R][C];
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				cheese[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		Queue<int[]> melt = new LinkedList<>();
		Queue<int[]> next_melt = new LinkedList<>();
		int[][] visit = new int[R][C];

		melt.add(new int[] { 0, 0 });
		visit[0][0] = 1;

		int time = 0;
		int max_idx = 0;
		while (!melt.isEmpty()) {
			int[] now = melt.poll();
			int cnt = visit[now[0]][now[1]];
			for (int d = 0; d < 4; d++) {
				int r = now[0] + dr[d];
				int c = now[1] + dc[d];
				// 맵 벗어나면 넘어가자
				if (r >= R || c >= C || r < 0 || c < 0)
					continue;
				// 이미 가본 곳이면 넘어가자
				if (visit[r][c] > 0)
					continue;

				// 빈 칸에 들어가면 이번에 한번 더 가자
				if (cheese[r][c] == 0) {
					visit[r][c] = cnt;
					melt.add(new int[] { r, c });
					continue;
				}
				// 치즈면 다음에 가자
				visit[r][c] = cnt + 1;
				next_melt.add(new int[] { r, c });
				if (max_idx < visit[r][c])
					max_idx = visit[r][c];
			}

			if (melt.isEmpty()) {
				time++;
				melt.addAll(next_melt);
				next_melt.clear();
			}
		}

		System.out.println(time - 1);
		int cnt = 0;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (visit[r][c] == time && cheese[r][c] == 1)
					cnt++;
			}
		}
		System.out.println(cnt);
	}
}
