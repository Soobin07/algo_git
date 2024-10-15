package beakjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q11060 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		int[] arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		long[] dp = new long[1001];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[1] = 0;
		for (int i = 1; i <= N; i++) {
			if (dp[i] >= Integer.MAX_VALUE)
				continue;
			for (int j = 1; j <= arr[i]; j++) {
				dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
			}
		}

		if (dp[N] >= Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(dp[N - 1]);
	}
}
