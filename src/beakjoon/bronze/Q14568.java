package beakjoon.bronze;

import java.util.Scanner;

public class Q14568 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int cnt = 0;
		for (int a = 2; a < N - 2; a += 2) {
			for (int b = 1; b < N; b++) {
				if (a + b >= N)
					break;
				for (int c = b + 2; c < N; c++) {
					if (a + b + c == N) {
						cnt++;
						break;
					}
				}
			}
		}

		System.out.println(cnt);
	}
}
