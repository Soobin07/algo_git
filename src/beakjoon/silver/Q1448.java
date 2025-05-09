package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1448 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		for (int i = N - 1; i >= 2; i--) {
			int a = arr[i];
			int b = arr[i - 1];
			int c = arr[i - 2];
			if (b + c > a) {
				System.out.println(a + b + c);
				return;
			}
		}
		System.out.println(-1);
	}
}
