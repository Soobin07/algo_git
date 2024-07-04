package beakjoon.silver;

import java.util.Scanner;

public class Q1735 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int A1 = sc.nextInt();
		int B1 = sc.nextInt();
		int A2 = sc.nextInt();
		int B2 = sc.nextInt();

		int mult = gcd(B1, B2);
		int B = (B1 * B2) / mult;
		int A_sum = A1 * (B / B1) + A2 * (B / B2);

		int mult2 = gcd(A_sum, B);

		System.out.println(A_sum / mult2 + " " + B / mult2);
	}

	public static int gcd(int A, int B) {
		int mult = 0;
		while (B != 0) {
			mult = A % B;
			A = B;
			B = mult;
		}
		return A;
	}
}
