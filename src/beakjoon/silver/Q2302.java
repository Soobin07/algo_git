package beakjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//극장 좌석
public class Q2302 {
	// 1자리 : 1 (1개)
	// 2자리 : [1,2][2,1] (2개)
	// 3자리 : [1,2,3][2,1,3][1,3,2] (3개)
	// 4자리 : [1,2,3,4][2,1,3,4][1,3,2,4][1,2,4,3][2,1,4,3] (5개)
	// f(n) = f(n - 1) + f(n - 2)

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] fixed = new int[M + 1];
		for (int i = 1; i <= M; i++) {
			fixed[i] = Integer.parseInt(br.readLine());
		}

		// 자리 덩어리 갯수 저장
		int[] dp = new int[41];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= N; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		// 방법 가짓수는 int범위!
		int ans = 1;

		// fixed된 자리 앞쪽 모두 처리
		for (int i = 1; i <= M; i++) {
			ans *= dp[fixed[i] - fixed[i - 1] - 1];
		}

		// N까지 처리
		// M이 0이면 자동으로 N-0들어감
		ans *= dp[N - fixed[M]];

		System.out.println(ans);
	}
}
