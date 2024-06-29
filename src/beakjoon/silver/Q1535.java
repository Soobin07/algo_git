package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//안녕
public class Q1535 {
	static int[] health, joy;
	static int ans, N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());

		health = new int[N];
		joy = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			health[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			joy[i] = Integer.parseInt(st.nextToken());
		}

		comb(0, 100, 0);

		System.out.println(ans);
	}

	static void comb(int idx, int h_sum, int j_sum) {
		// 인덱스 마지막 오면 끝
		if (idx == N) {
			if (h_sum > 0 && ans < j_sum)
				ans = j_sum;
			return;
		}
		// 죽으면 끝
		if (h_sum <= 0)
			return;

		// 인사 한다
		comb(idx + 1, h_sum - health[idx], j_sum + joy[idx]);
		// 안한다
		comb(idx + 1, h_sum, j_sum);
	}
}
