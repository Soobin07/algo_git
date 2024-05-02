package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//카드 구매하기 2
public class Q16194 {
	public static void main(String[] args) throws Exception {
		// 돈 최소 지불, 카드 N개 구매
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		int[] pay = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < 1 + N; i++) {
			pay[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[N + 1];
		dp[1] = pay[1];
		for (int i = 2; i <= N; i++) {
			dp[i] = pay[i];
			for (int j = 0; j <= i; j++) {
				dp[i] = Math.min(dp[i], pay[i - j] + dp[j]);
			}
		}
		System.out.println(dp[N]);
	}
}
