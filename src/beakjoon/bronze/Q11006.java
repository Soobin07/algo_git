package beakjoon.bronze;

import java.util.Scanner;

public class Q11006 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			int comp = N - M;
			System.out.printf("%d %d\n", M - comp, comp);
		}
	}
}
