package beakjoon.bronze;

import java.util.Scanner;

public class Q10801 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] A = new int[10];
		int[] B = new int[10];

		for (int i = 0; i < 10; i++) {
			A[i] = sc.nextInt();
		}
		for (int i = 0; i < 10; i++) {
			B[i] = sc.nextInt();
		}

		int a = 0;
		int b = 0;
		for (int i = 0; i < 10; i++) {
			if (A[i] > B[i]) {
				a++;
			} else if (A[i] < B[i]) {
				b++;
			} else {
				a++;
				b++;
			}
		}

		if (a > b) {
			System.out.println("A");
		} else if (a == b) {
			System.out.println("D");
		} else {
			System.out.println("B");
		}
	}
}
