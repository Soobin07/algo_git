package beakjoon.bronze;

import java.util.Scanner;

public class Q1292 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();

		int[] arr = new int[1001];
		int val = 1;
		int cnt = 0;
		for (int i = 1; i <= 1000; i++) {
			arr[i] = val;
			cnt++;
			if (val == cnt) {
				val++;
				cnt = 0;
			}
		}

		long ans = 0;
		for (int i = A; i <= B; i++) {
			ans += arr[i];
		}
		System.out.println(ans);
	}
}
