package beakjoon.bronze;

import java.util.Scanner;

//별 찍기 - 8
public class Q2445 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		StringBuffer sb = new StringBuffer();

		// 별 많아지는 줄
		for (int i = 1; i <= N; i++) {
			// 왼쪽 별
			for (int j = 0; j < i; j++) {
				sb.append("*");
			}
			// 왼쪽 빈칸
			for (int j = 0; j < N - i; j++) {
				sb.append(" ");
			}
			// 오른쪽 빈칸
			for (int j = 0; j < N - i; j++) {
				sb.append(" ");
			}
			// 오른쪽 별
			for (int j = 0; j < i; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		// 별 적어지는 줄
		for (int i = N - 1; i >= 1; i--) {
			// 왼쪽 별
			for (int j = 0; j < i; j++) {
				sb.append("*");
			}
			// 왼쪽 빈칸
			for (int j = 0; j < N - i; j++) {
				sb.append(" ");
			}
			// 오른쪽 빈칸
			for (int j = 0; j < N - i; j++) {
				sb.append(" ");
			}
			// 오른쪽 별
			for (int j = 0; j < i; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}
}
