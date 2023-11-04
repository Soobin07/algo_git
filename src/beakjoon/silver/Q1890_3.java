package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1890_3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		int[][] move_dist = new int[N][N];

		// 모든 move_dist는 0보다 크거나 같고 9보다 작거나 같다.
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				move_dist[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		long[][] ans = new long[N][N];
		ans[0][0] = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) { // 시작점 찾기
				// 못가거나 안움직이는 곳 패스
				if (ans[i][j] == 0 || move_dist[i][j] == 0)
					continue;

				// 오른쪽 이동
				if (i + move_dist[i][j] < N)
					ans[i + move_dist[i][j]][j] += ans[i][j]; // 이동할 곳으로 움직일 수 있는 경로 수 미리 넣어놓기
				// 아래로 이동
				if (j + move_dist[i][j] < N)
					ans[i][j + move_dist[i][j]] += ans[i][j];
			}
		}
		System.out.println(ans[N - 1][N - 1]);
	}
}
