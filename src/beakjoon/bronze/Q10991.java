package beakjoon.bronze;

import java.util.Scanner;

public class Q10991 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();

		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				sb.append(" ");
			}
			for (int j = 1; j < 2 * (i + 1); j++) {
				if (j % 2 == 0)
					sb.append(" ");
				else
					sb.append("*");
			}
			sb.append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.print(sb.toString());
	}
}
