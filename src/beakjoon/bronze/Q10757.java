package beakjoon.bronze;

import java.util.Scanner;

public class Q10757 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] A = new int[10001];
		int[] B = new int[10001];
		int[] ans = new int[10001];

		int longist = 0;
		String str = sc.next();
		longist = str.length();
		for (int j = 0; j < str.length(); j++) {
			A[j] = str.charAt(str.length() - 1 - j) - '0';
		}

		str = sc.next();
		longist = Math.max(longist, str.length());
		for (int j = 0; j < str.length(); j++) {
			B[j] = str.charAt(str.length() - 1 - j) - '0';
		}

		int up = 0;
		for (int i = 0; i < longist + 1; i++) {
			int tmp = A[i] + B[i];
			tmp = tmp + up;
			up = tmp / 10;
			ans[i] = tmp % 10;
		}

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < longist; i++) {
			sb.append(ans[i]);
		}
		if (ans[longist] != 0)
			sb.append(ans[longist]);

		sb.reverse();
		System.out.println(sb.toString());
	}
}
