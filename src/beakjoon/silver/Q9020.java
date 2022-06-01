package beakjoon.silver;

import java.util.Scanner;

public class Q9020 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean isNotPrime[] = new boolean[10001];
		isNotPrime[0] = isNotPrime[1] = true;
		for (int i = 2; i <= 10000; i++) {
			if (!isNotPrime[i]) {
				for (int j = i * i; j <= 10000; j += i) {
					isNotPrime[j] = true;
				}
			}
		}

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			for (int i = N / 2; i < N; i++) {
				if (!isNotPrime[i] && !isNotPrime[N - i]) {
					System.out.println((N - i) + " " + i);
					break;
				}
			}
		}
	}
}
