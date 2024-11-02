package beakjoon.bronze;

import java.util.Scanner;

public class Q1668 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int left = arr[0];
		int l_cnt = 1;
		int right = arr[N - 1];
		int r_cnt = 1;
		for (int i = 1; i < N; i++) {
			if (arr[i] > left) {
				left = arr[i];
				l_cnt++;
			}
			if (arr[N - i - 1] > right) {
				right = arr[N - i - 1];
				r_cnt++;
			}
		}
		System.out.println(l_cnt);
		System.out.println(r_cnt);
	}
}
