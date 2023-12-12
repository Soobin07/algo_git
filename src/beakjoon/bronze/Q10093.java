package beakjoon.bronze;

import java.util.Scanner;

public class Q10093 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();

		long A = sc.nextLong();
		long B = sc.nextLong();

		if (A > B) {
			long tmp = A;
			A = B;
			B = tmp;
		}

		if (A != B) {
			sb.append(B - A - 1);
			sb.append("\n");
			for (long i = A + 1; i < B; i++) {
				sb.append(i + " ");
			}

			sb.setLength(sb.length() - 1);
		} else {
			sb.append(0);
		}
		System.out.print(sb.toString());
	}
}
