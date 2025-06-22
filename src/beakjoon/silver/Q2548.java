package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2548 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		
		long all_sum = arr[N - 1] * N;
		int ans = arr[N - 1];
		for (int i = arr[0]; i < arr[N - 1]; i++) {
			long sum = 0;
			for (int j = 0; j < N; j++) {
				sum += Math.abs(arr[j] - i);
			}
			if (all_sum > sum) {
				all_sum = sum;
				ans = i;
			}
		}

		System.out.println(ans);
	}
}
