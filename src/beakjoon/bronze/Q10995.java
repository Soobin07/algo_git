package beakjoon.bronze;

import java.util.Scanner;

public class Q10995 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		int N = sc.nextInt();

		for (int i = 1; i <= N; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < N; j++) {
					sb.append(" *");
				}
			} else {
				for (int j = 0; j < N; j++) {
					sb.append("* ");
				}
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}
}
