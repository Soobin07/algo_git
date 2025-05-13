package beakjoon.silver;

import java.util.Scanner;

public class Q19939 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		// 최소 필요한 공
		int sml = K * (K + 1) / 2;

		if (N < sml) {
			System.out.println(-1);
			return;
		}

		int res = N - sml;
		int plus = res / K;
		int tmp = res % K;

		int max = K + plus + (tmp > 0 ? 1 : 0);
		int min = 1 + plus;

		System.out.println(max - min);
	}
}
