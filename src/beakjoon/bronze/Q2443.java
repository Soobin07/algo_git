package beakjoon.bronze;

import java.util.Scanner;

public class Q2443 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < N; i++) {
			// 앞쪽 공백
			for (int j = 0; j < i; j++) {
				sb.append(" ");
			}
			// 별
			for (int j = 0; j < 2 * N - 1 - i * 2; j++) {
				sb.append("*");
			}

			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
