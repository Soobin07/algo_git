package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q18808 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 세로
		int M = Integer.parseInt(st.nextToken()); // 가로
		int K = Integer.parseInt(st.nextToken()); // 스티커 갯수

		boolean[][] notebook = new boolean[N][M];

		int ans = 0;
		// k개 스티커 붙임
		for (int k = 0; k < K; k++) {
			// 스티커 크기 받기
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			boolean[][] sticker = new boolean[R][C];
			int cnt = 0;

			for (int r = 0; r < R; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < C; c++) {
					sticker[r][c] = Integer.parseInt(st.nextToken()) == 1 ? true : false;
					if (sticker[r][c]) {
						cnt++;
					}
				}
			}

			// 4방향 돌기
			outer: for (int d = 0; d < 4; d++) {
				// 붙는지 확인
				// 붙일 첫 자리 확인
				for (int i = 0; i <= N - sticker.length; i++) {
					for (int j = 0; j <= M - sticker[0].length; j++) {
						if (isPatched(notebook, sticker, i, j)) {
							patch(notebook, sticker, i, j);
							ans += cnt;
							break outer;
						}
					}
				}
				// 돌리기
				sticker = turn(sticker);
			}
		}
		System.out.println(ans);
	}

	static boolean[][] turn(boolean[][] sticker) {
		boolean[][] tmp = new boolean[sticker[0].length][sticker.length];
		for (int i = 0; i < sticker.length; i++) {
			for (int j = 0; j < sticker[0].length; j++) {
				tmp[j][sticker.length - 1 - i] = sticker[i][j];
			}
		}
		return tmp;
	}

	static boolean isPatched(boolean[][] notebook, boolean[][] sticker, int r, int c) {
		for (int i = 0; i < sticker.length; i++) {
			for (int j = 0; j < sticker[i].length; j++) {
				if (notebook[r + i][c + j] && sticker[i][j])
					return false;
			}
		}
		return true;
	}

	static void patch(boolean[][] notebook, boolean[][] sticker, int r, int c) {
		for (int i = 0; i < sticker.length; i++) {
			for (int j = 0; j < sticker[i].length; j++) {
				if (sticker[i][j]) {
					notebook[r + i][c + j] = sticker[i][j];
				}
			}
		}
	}
}
