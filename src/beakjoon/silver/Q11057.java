package beakjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

public class Q11057 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int mod = 10_007;

		int N = sc.nextInt();
		int[][] arr = new int[N][10];
		Arrays.fill(arr[0], 1);

		// i자리
		for (int i = 1; i < N; i++) {
			long sum = 0;
			for (int j = 0; j < 10; j++) {
				sum += arr[i - 1][j];
				sum %= mod;
				arr[i][j] = (int) sum;
			}
		}

		int ans = 0;
		for (int i = 0; i < 10; i++) {
			ans += arr[N - 1][i] % mod;
		}
		System.out.println(ans % mod);
	}
}
