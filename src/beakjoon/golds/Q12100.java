package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q12100 {
	static int N, ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// map 넣기
		N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 재귀 시작
		find(0, map);
		// 답 출력
		System.out.println(ans);
	}

	// 상하좌우 기울인 후, 합친다. 5회가 넘어가면 가장 높은 숫자를 찾는다
	static void find(int cnt, int[][] map) {
		if (cnt >= 5) { // 횟수는 최대 5회. 넘어가면 가장 높은 숫자 찾고 넘어가자.
			max(map);
			return;
		}

		// 상하좌우 기울인다
		for (int i = 0; i < 4; i++) {
			int[][] tmp = copy(map);
			move(i, tmp);
			sum(i, tmp);
			move(i, tmp);
			find(cnt + 1, tmp);
		}
	}

	// 가장 높은 숫자를 찾는다
	static void max(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] > ans)
					ans = map[i][j];
			}
		}
	}

	// 맵을 복사한다
	static int[][] copy(int[][] map) {
		int[][] tmp = new int[map.length][];
		for (int i = 0; i < map.length; i++) {
			tmp[i] = new int[map[i].length];
			for (int j = 0; j < map[i].length; j++) {
				tmp[i][j] = map[i][j];
			}
		}
		return tmp;
	}

	// 맵의 숫자를 이동한다
	static void move(int dist_idx, int[][] map) {
		if (dist_idx == 0) {
			// 제일 앞 [i][0] 빼고 움직일거임
			for (int i = 0; i < N; i++) {
				for (int j = 1; j < N; j++) { // 시작점 잡기
					int tmp = j; // 옮겨지는 숫자 idx
					while (true) { // 옮기기(앞이 끝이거나 숫자가 있을 때 까지 옮기기)
						tmp -= 1;
						if (tmp < 0 || map[i][tmp] > 0) { // 앞이 끝이거나 숫자가 있음
							map[i][tmp + 1] = map[i][j]; // 옮겨줌
							if (tmp + 1 != j)
								map[i][j] = 0;
							break;// 멈춤
						}
					}
				}
			}
		} else if (dist_idx == 1) {
			// 제일 앞 [0][i] 빼고 움직일거임
			for (int i = 1; i < N; i++) {
				for (int j = 0; j < N; j++) { // 시작점 잡기
					int tmp = i; // 옮겨지는 숫자
					while (true) { // 옮기기(앞이 끝이거나 숫자가 있을 때 까지 옮기기)
						tmp -= 1;
						if (tmp < 0 || map[tmp][j] > 0) { // 앞이 끝이거나 숫자가 있음
							map[tmp + 1][j] = map[i][j]; // 옮겨줌
							if (tmp + 1 != i)
								map[i][j] = 0;
							break;// 멈춤
						}
					}
				}
			}
		} else if (dist_idx == 2) {
			// 제일 뒤 [i][N-1] 빼고 움직일거임
			for (int i = 0; i < N; i++) {
				for (int j = N - 2; j >= 0; j--) { // 시작점 잡기
					int tmp = j; // 옮겨지는 숫자
					while (true) { // 옮기기(앞이 끝이거나 숫자가 있을 때 까지 옮기기)
						tmp += 1;
						if (tmp >= N || map[i][tmp] > 0) { // 앞이 끝이거나 숫자가 있음
							map[i][tmp - 1] = map[i][j]; // 옮겨줌
							if (tmp - 1 != j)
								map[i][j] = 0;
							break;// 멈춤
						}
					}
				}
			}
		} else {
			// 제일 앞 [N-1][i] 빼고 움직일거임
			for (int i = N - 2; i >= 0; i--) {
				for (int j = 0; j < N; j++) { // 시작점 잡기
					int tmp = i; // 옮겨지는 숫자
					while (true) { // 옮기기(앞이 끝이거나 숫자가 있을 때 까지 옮기기)
						tmp += 1;
						if (tmp >= N || map[tmp][j] > 0) { // 앞이 끝이거나 숫자가 있음
							map[tmp - 1][j] = map[i][j]; // 옮겨줌
							if (tmp - 1 != i)
								map[i][j] = 0;
							break;// 멈춤
						}
					}
				}
			}
		}
	}

	// 옆의 숫자와 비교하여 합친다
	static void sum(int dist_idx, int[][] map) {
		if (dist_idx == 0) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N - 1; j++) {
					if (map[i][j] != 0 && map[i][j] == map[i][j + 1]) {
						map[i][j] *= 2;
						map[i][j + 1] = 0;
					}
				}
			}
		} else if (dist_idx == 1) {
			for (int i = 0; i < N - 1; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] != 0 && map[i][j] == map[i + 1][j]) {
						map[i][j] *= 2;
						map[i + 1][j] = 0;
					}
				}
			}
		} else if (dist_idx == 2) {
			for (int i = 0; i < N; i++) {
				for (int j = N - 1; j > 0; j--) {
					if (map[i][j] != 0 && map[i][j] == map[i][j - 1]) {
						map[i][j] *= 2;
						map[i][j - 1] = 0;
					}
				}
			}
		} else {
			for (int i = N - 1; i > 0; i--) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] != 0 && map[i][j] == map[i - 1][j]) {
						map[i][j] *= 2;
						map[i - 1][j] = 0;
					}
				}
			}
		}
	}

	static void print(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
