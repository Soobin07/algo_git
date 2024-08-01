package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1987 {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static char[][] map;
	static int R, C, max;
	static int[] chr_cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		chr_cnt = new int['Z' - 'A' + 1];
		chr_cnt[map[0][0] - 'A'] = 1;
		for (int i = 0; i < 4; i++) {
			go(0 + dr[i], 0 + dc[i], 1);
		}

		System.out.println(max);
	}

	static void go(int r, int c, int cnt) {

		// 넘어가지 않니?
		if (r >= R || c >= C || r < 0 || c < 0) {
			max = Math.max(max, cnt);
			return;
		}
		// 이미 지나간 알파벳 아니니?
		if (chr_cnt[map[r][c] - 'A'] > 0) {
			max = Math.max(max, cnt);
			return;
		}

		// 지나간 알파벳 처리
		chr_cnt[map[r][c] - 'A']++;

		// 네 방향으로 가본다
		for (int i = 0; i < 4; i++) {
			go(r + dr[i], c + dc[i], cnt + 1);
		}

		chr_cnt[map[r][c] - 'A']--;
	}
}
