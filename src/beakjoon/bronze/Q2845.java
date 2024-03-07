package beakjoon.bronze;

import java.util.Scanner;

public class Q2845 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		int P = sc.nextInt();

		for (int i = 0; i < 5; i++) {
			System.out.print((sc.nextInt() - (L * P)) + " ");
		}
	}
}
