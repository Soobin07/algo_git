package beakjoon.silver;

import java.util.Scanner;

public class Q1926 {
	static int N, M, cnt, max, tmpMax;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		} // 맵 받기

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) { // 시작점 잡기
				if (map[i][j] == 1) {
					cnt++;
					tmpMax = 1;
					dfs(i, j);
				}
			}
		}
		System.out.println(cnt);
		System.out.println(max);
	}

	static void dfs(int r, int c) {
		if(max < tmpMax) max = tmpMax;
		map[r][c] = 2;	//방문처리
		tmpMax++;
		for(int i = 0 ; i < 4 ; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
			if(map[nr][nc] == 1) dfs(nr, nc);
		}
	}
}
