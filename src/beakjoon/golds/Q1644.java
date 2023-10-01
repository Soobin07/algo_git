package beakjoon.golds;

import java.util.Scanner;

public class Q1644 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		// 소수 찾기
		boolean[] isPrime = new boolean[4_000_001];
		for (int i = 2; i <= Math.sqrt(4_000_000); i++) {
			if (!isPrime[i]) {
				for (int j = i * 2; j <= 4_000_000; j += i) {
					isPrime[j] = true;
				}
			}
		}

		// 소수 갯수 카운트
		int cnt_prime = 0;
		for (int i = 2; i <= 4_000_000; i++) {
			if (!isPrime[i])
				cnt_prime++;
		}

		// 누적합
		long[] sum = new long[cnt_prime + 1];
		cnt_prime = 1;
		for (int i = 2; i <= 4_000_000; i++) {
			if (!isPrime[i]) {
				sum[cnt_prime] = sum[cnt_prime - 1] + i;
				cnt_prime++;
			}
		}

		// 시작수 잡고 찾아보기
		int cnt = 0;
		for (int i = 0; i < sum.length; i++) {
			for (int j = i + 1; j < sum.length; j++) {
				if (sum[j] - sum[i] == N)
					cnt++;
				if (sum[j] - sum[i] >= N)
					break;
			}
		}
		System.out.println(cnt);
	}
}
