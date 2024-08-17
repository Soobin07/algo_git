package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1253 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			int start = 0;
			int end = N - 1;

			while (start < end) {
				if (i == start) {
					start++;
					continue;
				} else if (i == end) {
					end--;
					continue;
				}

				int sum = arr[start] + arr[end];
				if (sum == arr[i]) {
					cnt++;
					break;
				} else if (sum < arr[i]) {
					start++;
				} else {
					end--;
				}
			}
		}
		System.out.println(cnt);
	}
}
