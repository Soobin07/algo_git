package beakjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

//올바른 배열
public class Q1337 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		int min = 4; // 필요한 숫자

		for (int i = 0; i < N; i++) {
			int start = i;
			int end = N - 1;
			int tmp_ans = 0;
			while (start < end) {
				if (arr[end] - arr[start] > 4) {
					end -= 1;
				} else {
					tmp_ans = 4 - (end - start);
					min = Math.min(min, tmp_ans);
					break;
				}
			}
		}

		System.out.println(min);
	}
}
