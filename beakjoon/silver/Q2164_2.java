package beakjoon.silver;

import java.util.Scanner;

public class Q2164_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// 1->1

		// 2->2

		// 3->2 => (3-2)*2 = 2
		// 4->4 => (4-2)*2 = 4

		// 5->2 => (5-4)*2 = 2
		// 6->4
		// 7->6
		// 8->8

		// 9->2
		// 10->4
		// 11->6
		// 12->8
		// 13->10
		// 14->12
		// 15->14
		// 16->16

		// N보다 작은 2의 승수

		if (N == 1) {
			System.out.println(1);
			return;
		}
		int n = 1;
		while (n < N) {
			n *= 2;
		}
		n /= 2;
		System.out.println((N - n) * 2);

	}
}
