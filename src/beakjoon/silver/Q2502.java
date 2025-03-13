package beakjoon.silver;

import java.util.Scanner;

// 떡 먹는 호랑이 s1
public class Q2502 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] mult = new int[31];
		mult[0] = 1;
		mult[1] = 0;
		for (int i = 2; i < 31; i++) {
			mult[i] = mult[i - 1] + mult[i - 2];
		}

		int d = sc.nextInt();
		int k = sc.nextInt();
		for (int a = 1; a <= k; a++) {
			for (int b = a; b <= k; b++) {
				long ans = mult[d - 1] * a + mult[d] * b;
				if (ans == k) {
					System.out.println(a);
					System.out.println(b);
					return;
				}
			}
		}
	}
}
