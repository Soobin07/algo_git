package beakjoon.silver;

import java.util.Scanner;

public class Q3474 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int n = sc.nextInt();
			int count = 0;
			long i = 5;
			while (i <= n) {
				count += (n / i);
				i *= 5;
			}
			System.out.println(count);
		}
	}
}
