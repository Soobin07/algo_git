package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q1388 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] map = new char[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		int count = 0;
		Stack<int[]> stack = new Stack<>();
		boolean[][] visit = new boolean[N][M];
		int[] dr = { 0, 1 };
		int[] dc = { 1, 0 };

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visit[i][j])
					continue;
				count++;
				visit[i][j] = true;
				int dir = 0;
				if (map[i][j] == '|')
					dir = 1;

				int r = i;
				int c = j;
				while (true) {
					r += dr[dir];
					c += dc[dir];
					if (r < 0 || r >= N || c < 0 || c >= M)
						break;
					if (map[r][c] != map[i][j])
						break;
					visit[r][c] = true;
				}
			}
		}
		System.out.println(count);
	}
}
