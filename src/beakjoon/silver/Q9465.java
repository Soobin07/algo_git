package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q9465 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			int[][] sticker = new int[2][n + 1];

			// 스티커 입력하기
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= n; j++) {
					sticker[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int[][] value = new int[2][n + 1];
			// 처음 1번 선택(위)
			value[0][1] = sticker[0][1];
			// 처음 1번 선택(아래)
			value[1][1] = sticker[1][1];

			// 2줄 이상인 경우에만
			if (n > 1) {
				value[0][2] = value[1][1] + sticker[0][2];
				value[1][2] = value[0][1] + sticker[1][2];

				for (int i = 3; i <= n; i++) {
					value[0][i] = Math.max(value[1][i - 1], Math.max(value[0][i - 2], value[1][i - 2])) + sticker[0][i];
					value[1][i] = Math.max(value[0][i - 1], Math.max(value[0][i - 2], value[1][i - 2])) + sticker[1][i];
				}
			}

			System.out.println(Math.max(value[0][n], value[1][n]));
		}
	}
}
