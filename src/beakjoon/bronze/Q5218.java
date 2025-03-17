package beakjoon.bronze;

import java.util.Arrays;
import java.util.Scanner;

public class Q5218 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for (int n = 0; n < N; n++) {
			char[] A = sc.next().toCharArray();
			char[] B = sc.next().toCharArray();

			int[] cnt = new int[A.length];

			for (int k = 0; k < A.length; k++) {
				int a = A[k] - 'A';
				int b = B[k] - 'A';

				if (b >= a) {
					cnt[k] = b - a;
				} else {
					cnt[k] = ((b + 26) - a);
				}
			}

			StringBuffer sb = new StringBuffer();
			sb.append("Distances: ");
			sb.append(Arrays.toString(cnt).replaceAll("[\\[\\],]", ""));
			System.out.println(sb.toString());
		}
	}
}
