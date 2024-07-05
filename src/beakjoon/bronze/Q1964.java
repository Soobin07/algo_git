package beakjoon.bronze;

import java.util.Scanner;

public class Q1964 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		long before = 5;
		long plus = 7;

		for (int i = 1; i < N; i++) {
			before += plus;
			plus += 3;
			before %= 45678;
		}

		System.out.println(before);
	}
}
