package beakjoon.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//전쟁-전투
public class Q1303 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		char[][] map = new char[M][N];
		boolean[][] visit = new boolean[M][N];

		long sumB = 0;
		long sumW = 0;

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		for (int i = 0; i < M; i++) {
			map[i] = sc.next().toCharArray();
		}

		Queue<int[]> q = new LinkedList<>();
		int cnt = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (visit[i][j])
					continue;

				q.clear();
				cnt = 1;

				q.add(new int[] { i, j });
				visit[i][j] = true;
				while (!q.isEmpty()) {
					int[] now = q.poll();
					for (int d = 0; d < 4; d++) {
						int ni = now[0] + dr[d];
						int nj = now[1] + dc[d];

						if (ni < 0 || ni >= M || nj < 0 || nj >= N)
							continue;
						if (visit[ni][nj])
							continue;
						if (map[ni][nj] != map[i][j])
							continue;

						cnt++;
						visit[ni][nj] = true;
						q.add(new int[] { ni, nj });
					}
				}
				if (map[i][j] == 'W') {
					sumW += Math.pow(cnt, 2);
				} else {
					sumB += Math.pow(cnt, 2);
				}
			}
		}

		System.out.println(sumW + " " + sumB);
	}
}
