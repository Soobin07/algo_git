package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

//동전2
public class Q2294 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		// n가지 종류 동전, 가치 합 k원, 동전 개수 최소
		// ans = 최소 동전 개수

		HashSet<Integer> coins = new HashSet<>();
		for (int i = 0; i < n; i++) {
			coins.add(Integer.parseInt(br.readLine()));
		}

		Integer[] coin = coins.toArray(new Integer[0]);
		Arrays.sort(coin);

		int[] dp = new int[k + 1];
		Arrays.fill(dp, Integer.MAX_VALUE - 1);
		dp[0] = 0;

		for (int i = 0; i < coin.length; i++) {
			for (int j = coin[i]; j <= k; j++) {
				dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);
			}
		}

		if (dp[k] == Integer.MAX_VALUE - 1)
			System.out.println(-1);
		else
			System.out.println(dp[k]);

	}
}
