package beakjoon.golds;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q5427 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = null;

		int TC = Integer.parseInt(br.readLine());
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };
		while (TC-- > 0) {
			// 조건 받기(넓이, 높이)
			st = new StringTokenizer(br.readLine());
			int W = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());

			// 맵 넣기
			char[][] map = new char[H][W];
			// 불 카운트 (몇번째 턴에 어디까지 갔나)
			int[][] f_cnt = new int[H][W];
			// 초기 불 카운트
			Queue<int[]> fires = new LinkedList<>();
			// 초기 상근이 위치
			Queue<int[]> sangun = new LinkedList<>();
			// 상근이 위치 카운트 (몇번째 턴에 어디까지 갔나)
			int[][] s_cnt = new int[H][W];

			// 맵 입력
			for (int i = 0; i < H; i++) {
				String tmp = br.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = tmp.charAt(j);
					if (map[i][j] == '*') {
						fires.add(new int[] { i, j });
						f_cnt[i][j] = 1;
					} else if (map[i][j] == '@') {
						sangun.add(new int[] { i, j });
						s_cnt[i][j] = 1;
					}
				}
			}

			// 불 카운트
			while (!fires.isEmpty()) {
				int rep = fires.size();
				for (int re = 0; re < rep; re++) {
					int[] now = fires.poll();
					int n_cnt = f_cnt[now[0]][now[1]];

					// 현재 위치에서 동서남북 간다
					for (int i = 0; i < dr.length; i++) {
						int r = now[0] + dr[i];
						int c = now[1] + dc[i];

						// 맵 벗어나면 패스
						if (r >= H || c >= W || r < 0 || c < 0)
							continue;
						// 벽이면 패스
						if (map[r][c] == '#')
							continue;
						// 이미 간 곳이면 패스
						if (f_cnt[r][c] > 0)
							continue;

						fires.add(new int[] { r, c });
						f_cnt[r][c] = n_cnt + 1;
					}
				}
			}

			// 사람 카운트
			boolean flag = false; // 탈출 성공하나?
			int n_cnt = 0;
			outer: while (!sangun.isEmpty()) {
				int rep = sangun.size();
				for (int re = 0; re < rep; re++) {
					int[] now = sangun.poll();
					n_cnt = s_cnt[now[0]][now[1]];

					// 현재 위치에서 동서남북 간다
					for (int i = 0; i < dr.length; i++) {
						int r = now[0] + dr[i];
						int c = now[1] + dc[i];

						// 맵 벗어나면 게임 끝
						if (r >= H || c >= W || r < 0 || c < 0) {
							flag = true;
							break outer;
						}
						// 벽이면 패스
						if (map[r][c] == '#')
							continue;
						// 이미 간 곳이면 패스
						if (s_cnt[r][c] > 0)
							continue;
						// 불이 났거나 날 곳이면 패스
						if (f_cnt[r][c] > 0 && f_cnt[r][c] <= n_cnt + 1)
							continue;

						sangun.add(new int[] { r, c });
						s_cnt[r][c] = n_cnt + 1;
					}
				}
			}

			if (flag) {
				bw.append(n_cnt + "\n");
			} else {
				bw.append("IMPOSSIBLE\n");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}