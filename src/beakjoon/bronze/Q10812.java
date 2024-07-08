package beakjoon.bronze;

import java.util.Scanner;

public class Q10812 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();

		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] arr = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			arr[i] = i;
		}

		for (int m = 0; m < M; m++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int mid = sc.nextInt();

			int[] tmp = new int[end - start + 1];
			for (int i = 0; i <= end - mid; i++) {
				tmp[i] = arr[mid + i];
			}
			for (int i = 0; i < mid - start; i++) {
				tmp[i + end - mid + 1] = arr[start + i];
			}

			for (int i = 0; i <= end - start; i++) {
				arr[i + start] = tmp[i];
			}
		}

		for (int i = 0; i < N; i++) {
			sb.append(arr[i + 1] + " ");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}
