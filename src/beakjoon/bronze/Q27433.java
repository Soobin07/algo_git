package beakjoon.bronze;

import java.util.Scanner;

public class Q27433 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		long A = 1L;
		for (int i = 1; i <= N; i++) {
			A *= i;
		}
		
		System.out.println(A);
	}
}
