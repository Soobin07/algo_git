package beakjoon.bronze;

import java.util.Scanner;

public class Q26082 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double A = sc.nextDouble();
		int B = sc.nextInt();
		int C = sc.nextInt();

		System.out.println((int) ((B / A) * 3 * C));
	}
}
