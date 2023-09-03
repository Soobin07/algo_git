package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q17070 {
	static int[][] map;
	static int N, ans;
	static int[] dr = { 0, 1, 1 };
	static int[] dc = { 1, 1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());

		map = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		find(0, 1, 1);
		System.out.println(ans);
	}

	static void find(int dist, int r, int c) {
		r += dr[dist];
		c += dc[dist];
		if (r == N && c == N) {
			if (map[r][c] == 0) {
				if(dist == 1&&(map[r - 1][c] != 0 || map[r][c - 1] != 0)) {
					return;
				}
				ans++;
			}
			return;
		}
		if (r <= N && c <= N && map[r][c] == 0) {
			// 직선인 경우
			if (dist % 2 == 0) {
				// 그대로 한번 더
				find(dist, r, c);
				// 대각선으로 한번 더
				find(1, r, c);
			} else {
				// 대각선인 경우
				// 3개가 다 비어있어야 다음 턴으로 넘어갈 수 있다
				if (map[r - 1][c] == 0 && map[r][c - 1] == 0) {
					// 그대로 한번 더
					find(dist, r, c);
					// 가로로
					find(0, r, c);
					// 세로로
					find(2, r, c);
				}
			}
		}
	}
}
