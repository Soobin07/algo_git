package beakjoon.bronze;

import java.util.Scanner;

public class Q25191 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int A = sc.nextInt();
		int B = sc.nextInt();

		int S = A / 2 + B;
		System.out.println(Math.min(S, N));
	}
}
