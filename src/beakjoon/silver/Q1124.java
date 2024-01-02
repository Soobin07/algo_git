package beakjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

public class Q1124 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();

		int[] cnt = new int[B - A + 1];
		int[] arr = new int[B - A + 1];
		boolean[] prime = new boolean[B + 1];

		Arrays.fill(prime, true);
		prime[0] = false;
		prime[1] = false;

		// 이것은 소수인가
		for (int i = 2; i <= B; i++) {
			if (prime[i]) {
				for (int j = i * i; j <= B; j += i) {
					if (j < 0)
						break;
					prime[j] = false;
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			// 숫자를 넣는다
			arr[i] = i + A;
			
			//prime로 나눈다
			int idx = 2;
			while (true) {
				if (prime[arr[i]]) {
					cnt[i]++;
					break;
				}
				if (arr[i] % idx == 0) {
					arr[i] /= idx;
					cnt[i]++;
				} else {
					while (true) {
						idx++;
						if (prime[idx])
							break;
					}
				}
			}
		}

		int ans = 0;
		// 언더프라임을 찾는다
		for (int i = 0; i < cnt.length; i++) {
			if (prime[cnt[i]]) {
				ans++;
			}
		}

		System.out.println(ans);
	}
}
