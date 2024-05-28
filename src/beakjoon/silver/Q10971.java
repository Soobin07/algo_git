package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//외판원 순회 2
public class Q10971 {
	static int[][] cost;
	static boolean[] visit;
	static int ans, N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		cost = new int[N][N];
		visit = new boolean[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		ans = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			visit[i] = true;
			getCost(0, i, 0, i);
			visit[i] = false;
		}
		System.out.println(ans);
	}

	static void getCost(int num, int before, int sum, int first) {
		if (num == N - 1) {
			if (goAll() && cost[before][first] > 0)
				ans = Math.min(ans, sum + cost[before][first]);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!visit[i] && cost[before][i] > 0) {
				visit[i] = true;
				getCost(num + 1, i, sum + cost[before][i], first);
				visit[i] = false;
			}
		}
	}

	static boolean goAll() {
		for (int i = 0; i < N; i++) {
			if (!visit[i])
				return false;
		}
		return true;
	}
}
