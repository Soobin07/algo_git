package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15684 {
	static int ans, N, M, H;
	static boolean[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		ans = 4;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new boolean[H + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
		}

		create(1, 0);

		if (ans == 4)
			ans = -1;
		System.out.println(ans);
	}

	// 모든 i가 i에서 끝나는지 확인하기 위한 함수
	static boolean game_start() {
		boolean flag = true;
		for (int i = 1; i <= N; i++) {
			int curr = i;
			for (int j = 1; j <= H; j++) {
				// 오른쪽 가능?
				if (map[j][curr])
					curr += 1;
				else if (map[j][curr - 1])
					curr -= 1;
			}
			// 다른곳에 도착
			if (curr != i) {
				// i에서 안끝나네? 이대로 false 던지자
				flag = false;
				break;
			}
		}
		return flag;
	}

	// idx 밑의 가로줄에 줄 그어서 전부 되는지 확인
	static void create(int idx, int created_line) {
		if (created_line >= 4)
			return;
		if (game_start()) {
			ans = Math.min(created_line, ans);
			return;
		}
		for (int i = idx; i <= H; i++) {
			for (int j = 1; j < N; j++) {
				if (map[i][j])
					continue;
				if (map[i][j - 1])
					continue;
				if (map[i][j + 1])
					continue;

				map[i][j] = true;
				create(i, created_line + 1);
				map[i][j] = false;
			}
		}
	}
}
