package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q17140 {
	static int R, C, K, ans, big_r, big_c;
	static int[][] map, tmp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 조건 받기
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		// 배열 A 받기
		map = new int[100][100];
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 지난 시간
		int time = 0;
		// 답
		ans = -1;
		big_r = big_c = 3;
		while (true) {
			// 종료조건 -> 100넘어도 안되면 종료해라
			if (time > 100)
				break;
			// 종료조건 -> map[R][C] ==K면 종료해라
			if (map[R - 1][C - 1] == K) {
				ans = time;
				break;
			}

			// 연산
			if (big_r >= big_c)
				sort_r();
			else
				sort_c();

			time++;
		}
		System.out.println(ans);
	}

	static void sort_r() {
		int max_c = big_c;
		big_c = 0;
		tmp = new int[100][100];

		// 한 행 씩 cnt해서 넣음
		for (int i = 0; i <= big_r; i++) {
			int[] cnt_arr = new int[101];
			int max = 0;
			for (int j = 0; j <= max_c; j++) {
				cnt_arr[map[i][j]]++;
			}
			// cnt의 max 찾기
			for (int j = 1; j <= 100; j++) {
				max = Math.max(max, cnt_arr[j]);
			}
			int idx = 0;
			for (int j = 1; j <= max; j++) {
				for (int k = 1; k <= 100; k++) {
					if (cnt_arr[k] == j) {
						tmp[i][idx] = k;
						tmp[i][idx + 1] = j;
						idx += 2;
					}
				}
			}
			// big_r = Math.max(big_r, i + 1);
			// 한 줄 정렬해서 tmp에 넣기
			big_c = Math.max(big_c, idx);
		}

		map = tmp;
	}

	static void sort_c() {
		int max_r = big_r;
		big_r = 0;
		tmp = new int[100][100];
		
		// 한 열 씩 cnt해서 넣음
		for (int i = 0; i <= big_c; i++) {
			int[] cnt_arr = new int[101];
			int max = 0;
			for (int j = 0; j <= max_r; j++) {
				cnt_arr[map[j][i]]++;
			}
			// cnt의 max 찾기
			for (int j = 1; j <= 100; j++) {
				max = Math.max(max, cnt_arr[j]);
			}
			int idx = 0;
			for (int j = 1; j <= max; j++) {
				for (int k = 1; k <= 100; k++) {
					if (cnt_arr[k] == j) {
						tmp[idx][i] = k;
						tmp[idx + 1][i] = j;
						idx += 2;
					}
				}
			}
			// 한 줄 정렬해서 tmp에 넣기
			big_r = Math.max(big_r, idx);
			// big_c = Math.max(big_c, i);
		}

		map = tmp;
	}
}
