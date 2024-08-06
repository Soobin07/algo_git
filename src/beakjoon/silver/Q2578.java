package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2578 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// 입력
		int[][] map = new int[5][5];
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 게임
		int cnt = 0;
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				cnt++;
				find(map, Integer.parseInt(st.nextToken()));
				if (bingo(map) >= 3) {
					System.out.println(cnt);
					return;
				}
			}
		}
	}

	static void find(int[][] map, int num) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (map[i][j] == num) {
					map[i][j] = 0;
					return;
				}
			}
		}
	}

	static int bingo(int[][] map) {
		int cnt = 0;
		// 가로
		for (int i = 0; i < 5; i++) {
			boolean flag = true;
			for (int j = 0; j < 5; j++) {
				if (map[i][j] != 0) {
					flag = false;
					break;
				}
			}
			if (flag) {
				cnt++;
			}
		}
		// 세로
		for (int i = 0; i < 5; i++) {
			boolean flag = true;
			for (int j = 0; j < 5; j++) {
				if (map[j][i] != 0) {
					flag = false;
					break;
				}
			}
			if (flag) {
				cnt++;
			}
		}
		// 대각선 1
		boolean flag = true;
		for (int i = 0; i < 5; i++) {
			if (map[i][i] != 0) {
				flag = false;
				break;
			}
		}
		if (flag)
			cnt++;
		// 대각선 2
		flag = true;
		for (int i = 0; i < 5; i++) {
			if (map[i][4 - i] != 0) {
				flag = false;
				break;
			}
		}
		if (flag)
			cnt++;
		return cnt;
	}
}
