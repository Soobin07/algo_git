package beakjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//점프점프
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

		long[] dp = new long[N + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[1] = 0;

		for (int i = 1; i < N; i++) {
			long cnt = dp[i];
			for (int j = 1; j <= arr[i] && (i + j) <= N; j++) {
				dp[i + j] = Math.min(cnt + 1, dp[i + j]);
			}
		}

		if (dp[N] >= Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(dp[N]);
	}
}
