package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q17144 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken()); // 세로
		int C = Integer.parseInt(st.nextToken()); // 가로
		int T = Integer.parseInt(st.nextToken()); // 초

		// 공기청정기
		int r_idx = 0;
		int[][] robot = new int[2][2];
		// 맵 넣기
		int[][] map = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1) {
					robot[r_idx] = new int[] { i, j };
					r_idx++;
				}
			}
		}

		// 4방향 좌표
		int[] dr = { 1, 0, -1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		// 미세먼지 확장시 좌표 확인용
		int tmp_r = 0;
		int tmp_c = 0;
		// 미세먼지 확장시 확장 방향 갯수 확인용
		int tmp_dir = 0;
		// T초 돌리기
		int time = 0;
		while (time < T) {
			// 미세먼지 확장 동시에 하기 위해서
			int[][] map_tmp = new int[R][C];
			time++;
			// 1. 미세먼지 확산 (동시)
			// 전체 맵 확인
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					// 확산될 미세먼지 있는 곳 확인
					if (map[i][j] > 0) {
						// 4방향 확산
						tmp_dir = 0;
						for (int k = 0; k < 4; k++) {
							tmp_r = i + dr[k];
							tmp_c = j + dc[k];
							// 4방 확인 후 맵 밖 or 공기청정기 아닌지 확인
							if (tmp_r >= R || tmp_r < 0 || tmp_c >= C || tmp_c < 0 || map[tmp_r][tmp_c] == -1)
								continue;

							// 확산되는 방향 갯수 추가
							tmp_dir++;
							// 확산되는 칸에 미세먼지 양 더하기
							map_tmp[tmp_r][tmp_c] += map[i][j] / 5;
						}
						// 확산 후 남은 양
						map_tmp[i][j] += map[i][j] - (map[i][j] / 5) * tmp_dir;
						// + 음수 방지
						map_tmp[i][j] = Math.max(0, map_tmp[i][j]);
					}
				}
			}
			// 2. 공기청정기 작동
			// 위쪽 청정기는 반시계방향으로 밀어냄 => 시계방향으로 당겨오면 되겠다.
			tmp_r = robot[0][0];
			tmp_c = robot[0][1];
			// 위쪽을 아래로 끌어오기
			while (true) {
				tmp_r--;
				if (tmp_r < 0)
					break;
				map_tmp[tmp_r + 1][tmp_c] = map_tmp[tmp_r][tmp_c];
			}
			// 위에서 tmp_r이 -1이 되어있으니 0으로 돌려주기
			tmp_r = 0;
			// 왼쪽으로 끌어오기
			while (true) {
				tmp_c++;
				if (tmp_c >= C)
					break;
				map_tmp[tmp_r][tmp_c - 1] = map_tmp[tmp_r][tmp_c];
			}
			// 위에서 tmp_c가 C가 되어 있으니 C-1로 돌려주기
			tmp_c = C - 1;
			// 위로 끌어 올리기
			while (true) {
				tmp_r++;
				if (tmp_r > robot[0][0])
					break;
				map_tmp[tmp_r - 1][tmp_c] = map_tmp[tmp_r][tmp_c];
			}
			tmp_r = robot[0][0];
			// 오른쪽으로 밀기
			while (true) {
				tmp_c--;
				if (tmp_c <= 0)
					break;
				map_tmp[tmp_r][tmp_c + 1] = map_tmp[tmp_r][tmp_c];
			}
			map_tmp[robot[0][0]][robot[0][1]] = -1;

			// 아래쪽 청정기는 시계방향으로 순환함 => 반시계방향으로 당겨오면 되겠다
			tmp_r = robot[1][0];
			tmp_c = robot[1][1];
			// 위로 끌어 올리기
			while (true) {
				tmp_r++;
				if (tmp_r >= R)
					break;
				map_tmp[tmp_r - 1][tmp_c] = map_tmp[tmp_r][tmp_c];
			}
			tmp_r = R - 1;
			// 왼쪽으로 당기기
			while (true) {
				tmp_c++;
				if (tmp_c >= C)
					break;
				map_tmp[tmp_r][tmp_c - 1] = map_tmp[tmp_r][tmp_c];
			}
			tmp_c = C - 1;
			// 아래로 내리기
			while (true) {
				tmp_r--;
				if (tmp_r < robot[1][0])
					break;
				map_tmp[tmp_r + 1][tmp_c] = map_tmp[tmp_r][tmp_c];
			}
			tmp_r = robot[1][0];
			// 오른쪽으로 밀기
			while (true) {
				tmp_c--;
				if (tmp_c <= 0)
					break;
				map_tmp[tmp_r][tmp_c + 1] = map_tmp[tmp_r][tmp_c];
			}
			map_tmp[robot[1][0]][robot[1][1]] = -1;

			map_tmp[robot[0][0]][robot[0][1] + 1] = 0;
			map_tmp[robot[1][0]][robot[1][1] + 1] = 0;

			map = map_tmp;
		}
		long ans = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0)
					ans += map[i][j];
			}
		}
		System.out.println(ans);
	}

	/*
	 * static void print(int[][] arr) { StringBuffer sb = new StringBuffer(); for
	 * (int i = 0; i < arr.length; i++) { for (int j = 0; j < arr[i].length; j++) {
	 * sb.append(arr[i][j] + " "); } sb.append("\n"); }
	 * System.out.println(sb.toString()); }
	 */
}
