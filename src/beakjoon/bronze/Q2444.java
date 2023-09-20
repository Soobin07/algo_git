package beakjoon.bronze;

import java.util.Scanner;

public class Q2444 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - i - 1; j++) {
				System.out.print(' ');
			}
			for (int j = 0; j < i * 2 + 1; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
		for (int i = 1; i < N; i++) {
			for(int j = 0 ; j < i ; j++) {
				System.out.print(' ');
			}
			for (int j = 0; j < (N - 1 - i) * 2 + 1; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
	}
}
