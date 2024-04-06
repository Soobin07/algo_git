package beakjoon.bronze;

import java.util.Scanner;

public class Q10992 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();

		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			for (int j = i; j < N - 1; j++) {
				sb.append(" ");
			}
			if (i == 0) { // 처음이면 하나만 넣어주기
				sb.append("*");
			} else if (i == N - 1) { // 마지막이면 전부 더하기
				for (int j = 0; j <= i * 2; j++) {
					sb.append("*");
				}
			} else { // 중간이면
				sb.append("*");
				for (int j = 0; j < i * 2 - 1; j++) {
					sb.append(" ");
				}
				sb.append("*");
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}
