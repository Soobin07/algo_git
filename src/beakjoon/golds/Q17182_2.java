package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//우주 탐사선
public class Q17182_2 {
	static int[][] T;
	static int time;
	static boolean[] visit;
	static int ans, N, K;

	public static void main(String[] args) throws Exception {
		// 모든 행성을 탐사하는데 걸리는 최소 시간
		// 행성 위치는 0,0~
		// i,j는 i행성에서 j행성 가는데 걸리는 시간
		// 중복해서 갈 수 있고, 시작 행성으로 다시 돌아올 필요 없음

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 행성 개수 N (2<= N <= 10)
		N = Integer.parseInt(st.nextToken());
		// 발사되는 행성 위치 K (0 <= K < N)
		K = Integer.parseInt(st.nextToken());

		// 행성 간 이동 시간 Tij (0 <= Tij <= 1000)
		T = new int[N][N];

		for (int i = 0; i < N; i++) {
			Arrays.fill(T[i], Integer.MAX_VALUE);
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				T[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 플로이드를 이요하여 최단거리를 구함
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (T[i][k] + T[k][j] < T[i][j])
						T[i][j] = T[i][k] + T[k][j];
				}
			}
		}

		visit = new boolean[N];
		visit[K] = true;

		ans = Integer.MAX_VALUE;

		start(1, K, 0);
		System.out.println(ans);

	}

	static void start(int cnt, int prev, int time) {
		if (cnt == N) {
			ans = Math.min(ans, time);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (visit[i])
				continue;
			visit[i] = true;
			start(cnt + 1, i, time + T[prev][i]);
			visit[i] = false;
		}
	}
}
