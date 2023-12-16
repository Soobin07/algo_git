package beakjoon.bronze;

import java.util.Scanner;

public class Q5073 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int C = sc.nextInt();

			if (A == 0 && B == 0 && C == 0)
				break;
			int biggest = Math.max(Math.max(A, B), C);
			int sum = A + B + C;
			if (biggest >= sum - biggest) {
				System.out.println("Invalid");
				continue;
			}
			if (A != B && B != C && C != A) {
				System.out.println("Scalene");
			} else if (A == B && B == C && C == A) {
				System.out.println("Equilateral");
			} else {
				System.out.println("Isosceles");
			}
		}
	}
}
