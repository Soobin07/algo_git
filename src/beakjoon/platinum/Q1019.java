package beakjoon.platinum;

import java.util.*;

public class Q1019 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		long[] cnts = new long[10];
		int len = N.length();
		long pow = 1;

		for (int i = 0; i < len; i++) {
			int c = N.charAt(len - 1 - i) - '0';
			int left = (len - 1 - i > 0) ? Integer.parseInt(N.substring(0, len - 1 - i)) : 0;
			int right = (i > 0) ? Integer.parseInt(N.substring(len - i, len)) : 0;

			for (int j = 1; j < 10; j++) {
				cnts[j] += left * pow;
				if (c > j) {
					cnts[j] += pow;
				} else if (c == j) {
					cnts[j] += (right + 1);
				}
			}

			if (left > 0) {
				cnts[0] += (left - 1) * pow;
				if (c > 0) {
					cnts[0] += pow;
				} else if (c == 0) {
					cnts[0] += (right + 1);
				}
			}

			pow *= 10;
		}

		for (int i = 0; i < 10; i++) {
			System.out.print(cnts[i] + " ");
		}
	}
}
