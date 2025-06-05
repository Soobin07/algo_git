package beakjoon.bronze;

import java.util.Scanner;

public class Q10990 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < N - 1; i++) {
			sb.append(" ");
		}
		sb.append("*");
		sb.append("\n");
		for (int i = 1; i < N; i++) {
			for (int j = i; j < N - 1; j++) {
				sb.append(" ");
			}
			sb.append("*");
			for (int j = 0; j < i * 2 - 1; j++) {
				sb.append(" ");
			}
			sb.append("*");
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}
}
