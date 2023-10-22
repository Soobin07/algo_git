package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//드래곤커브
public class Q15685 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int ans = 0;

		boolean[][] map = new boolean[101][101];
		int[] dr = { 0, -1, 0, 1 };
		int[] dc = { 1, 0, -1, 0 };

		int N = Integer.parseInt(br.readLine());
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int[] start = { y, x };
			int dir = Integer.parseInt(st.nextToken());
			int G = Integer.parseInt(st.nextToken());

			// 드래곤커브 그리기
			int[] dir_memory = new int[(int) Math.pow(2, G)];
			// 초기 설정 집어넣기
			dir_memory[0] = dir; // 초기 방향
			// 세대 내려가기
			for (int g = 0; g < G; g++) {
				for (int t = 0; t < (int) Math.pow(2, g); t++) {
					int d = dir_memory[(int) Math.pow(2, g) - 1 - t];
					int new_d = (d + 1) % 4;
					dir_memory[(int) Math.pow(2, g) + t] = new_d;
				}
			}
			// 해당되는 점 모두 true 처리하기
			if (isInside(start))
				map[start[0]][start[1]] = true;
			for (int g = 0; g < dir_memory.length; g++) {
				start[0] += dr[dir_memory[g]];
				start[1] += dc[dir_memory[g]];
				if (isInside(start))
					map[start[0]][start[1]] = true;
			}
		}
		// 맵 전부 찾아보면서 네모 찾기
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1])
					ans++;
			}
		}
		System.out.println(ans);
	}

	static boolean isInside(int[] dot) {
		if (dot[0] < 0 || dot[0] > 100)
			return false;
		if (dot[1] < 0 || dot[1] > 100)
			return false;
		return true;
	}
}
