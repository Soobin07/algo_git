package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q15988 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		long dp[] = new long[1_000_001];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for(int i = 4 ; i <= 1_000_000; i++) {
			dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % 1_000_000_009;
		}
		
		for(int tc = 0 ; tc < TC ; tc++) {
			System.out.println(dp[Integer.parseInt(br.readLine())]);
		}
	}
}
