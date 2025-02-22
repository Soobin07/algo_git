package beakjoon.bronze;

import java.util.Scanner;

public class Q23971 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double H = sc.nextDouble();
		double W = sc.nextDouble();
		double N = sc.nextDouble();
		double M = sc.nextDouble();

		int a = (int) Math.ceil(W / (M + 1));
		int b = (int) Math.ceil(H / (N + 1));
		int ans = a * b;
		System.out.println(ans);
	}
}
