package beakjoon.bronze;

import java.util.Scanner;

public class Q10409 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int T = sc.nextInt();

		int[] times = new int[n];
		for (int i = 0; i < n; i++) {
			times[i] = sc.nextInt();
		}

		int sum = 0;
		boolean flag = true;
		for (int i = 0; i < n; i++) {
			sum += times[i];
			if (sum > T) {
				System.out.println(i);
				flag = false;
				break;
			}
		}
		if (flag && sum <= T)
			System.out.println(n);
	}
}
