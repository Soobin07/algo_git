package beakjoon.bronze;

import java.util.Scanner;

public class Q20053 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			for (int n = 0; n < N; n++) {
				int tmp = sc.nextInt();
				max = Math.max(max, tmp);
				min = Math.min(min, tmp);
			}
			System.out.println(min + " " + max);
		}
	}
}
