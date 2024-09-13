package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q17103 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		// 소수 미리 구하기
		boolean[] not_prime = new boolean[1_000_001];
		not_prime[0] = not_prime[1] = true;
		for (int i = 2; i * i <= 1_000_000; i++) {
			if (not_prime[i])
				continue;
			for (int j = 2 * i; j <= 1_000_000; j += i) {
				not_prime[j] = true;
			}
		}

		// TC 하나씩 가져와서 풀기
		for (int t = 0; t < T; t++) {
			int tmp = Integer.parseInt(br.readLine());
			int ans = 0;
			// 두개 더해서 tmp인가?
			for (int i = 2; i <= tmp / 2; i++) {
				if (!not_prime[i] && !not_prime[tmp - i])
					ans++;
			}
			System.out.println(ans);
		}
	}
}
