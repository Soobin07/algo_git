package beakjoon.silver;

import java.util.Scanner;

public class Q2089 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();

		// N = 0
		if (N == 0) {
			System.out.println(0);
			return;
		}

		StringBuffer sb = new StringBuffer();

		while (N != 0) {
			long rem = N % -2;
			N /= -2;

			if (rem < 0) {
				rem += 2;
				N += 1;
			}
			sb.append(rem);
		}

		System.out.println(sb.reverse().toString());
	}
}
