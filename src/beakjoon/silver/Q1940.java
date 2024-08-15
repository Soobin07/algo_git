package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1940 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int ans = 0;
		int start = 0;
		int end = N - 1;

		while (start < end) {
			if (arr[start] + arr[end] < M) {
				start++;
			} else if (arr[start] + arr[end] > M) {
				end--;
			} else {
				ans++;
				start++;
				end--;
			}
		}

		System.out.println(ans);
		br.close();
	}
}
