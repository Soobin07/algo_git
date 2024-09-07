package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//Four Squares
public class Q17626 {
	// 1. 단순 브루트포스 => 34567을 넣는 순간 0.5초보다 느렸음
	/*
	 * static int[] squr; static int N, min;
	 * 
	 * public static void main(String[] args) throws Exception { BufferedReader br =
	 * new BufferedReader(new InputStreamReader(System.in)); int N_max = 50000; squr
	 * = new int[(int) Math.sqrt(N_max) + 1]; for (int i = 1; i < squr.length; i++)
	 * { squr[i] = i * i; }
	 * 
	 * N = Integer.parseInt(br.readLine()); min = Integer.MAX_VALUE;
	 * 
	 * find((int) Math.sqrt(N), 0, 0);
	 * 
	 * System.out.println(min); }
	 * 
	 * // 현재 idx, 지금까지 sum, 지금까지 사용한 숫자 갯수 static void find(int idx, int sum, int
	 * cnt) {
	 * 
	 * // 이미 얘보다 작은 갯수 구했다. // 이 분기는 종료한다 if (cnt > min) return;
	 * 
	 * // 더하는 갯수를 줄이기 위해 큰 수부터 더한다. for (int i = idx; i >= 1; i--) { int t_sum = sum
	 * + squr[i];
	 * 
	 * // 더한게 N보다 크면 더 작은 수를 더해본다 if (t_sum > N) continue;
	 * 
	 * // 더한게 딱 N이면 찾던거다. 여기서 더 더하면 숫자 늘어나기만 한다. // 이 분기는 종료한다. if (t_sum == N) { if
	 * (cnt + 1 < min) min = cnt + 1; return; }
	 * 
	 * // 아직 더 더해야 하면, 이번거 포함해서 가자 find(i, t_sum, cnt + 1); } }
	 */

	// 2. N을 만들 수 있는 갯수를 메모를 하여 사용한다
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n_max = 50000;
		int[] dp = new int[n_max + 1];

		int N = Integer.parseInt(br.readLine());
		// N 까지만 비교하면 된다
		for (int i = 1; i <= N; i++) {
			// i를 몇 개의 제곱 수를 더하여 만들 수 있는지 확인한다.
			// 이전 것에 1을 더해서 완성했을 때
			dp[i] = dp[i - 1] + 1;
			// i보다 작은 제곱수를 더해서 i를 만들어 본다
			for (int j = 1; j * j <= i; j++) {
				// i 하나 앞 수에 1을 더하여 만든 갯수와
				// i에서 j*j만큼을 j의 제곱으로 뺀 (+1) 후 나머지를 만들 수 있는 갯수를
				// 비교한다
				dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
			}
		}
		System.out.println(dp[N]);
	}
}
