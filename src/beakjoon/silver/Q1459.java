package beakjoon.silver;

import java.util.Scanner;

public class Q1459 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long X = sc.nextInt();
		long Y = sc.nextInt();
		long W = sc.nextInt();
		long S = sc.nextInt();

		long ans1 = (X + Y) * W;
		long ans2 = 0;
		if ((X + Y) % 2 == 0)
			ans2 = Math.max(X, Y) * S;
		else
			ans2 = (Math.max(X, Y) - 1) * S + W;
		long ans3 = (Math.min(X, Y) * S + Math.abs(X - Y) * W);

		System.out.println(Math.min(ans1, Math.min(ans2, ans3)));
	}
}
