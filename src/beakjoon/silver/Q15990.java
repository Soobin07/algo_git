package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//1, 2, 3 더하기 5
public class Q15990 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[][] dp = new long[100_001][4];
		int mod = 1_000_000_009;
		// 앞에 있는 수를 만들고, 뒤에 있는 수가 마지막 숫자
		// 1 : 1, 2 : 2, 3 : (1+2)(2+1)(3)
		dp[1][1] = dp[2][2] = dp[3][1] = dp[3][2] = dp[3][3] = 1; // 초기 1, 2, 3
		for (int n = 4; n < dp.length; n++) {
			if (n - 1 >= 0)
				dp[n][1] = (dp[n - 1][2] + dp[n - 1][3]) % mod;
			if (n - 2 >= 0)
				dp[n][2] = (dp[n - 2][1] + dp[n - 2][3]) % mod;
			if (n - 3 >= 0)
				dp[n][3] = (dp[n - 3][1] + dp[n - 3][2]) % mod;
		}
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			System.out.println((dp[N][1] + dp[N][2] + dp[N][3]) % mod);
		}
	}
}
