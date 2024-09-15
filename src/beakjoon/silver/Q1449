package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1449 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 물 새는 곳 개수
		int L = Integer.parseInt(st.nextToken()); // 테이프 길이 L

		int sum = 0;
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		int start = 0;
		int cnt = 1;
		for (int i = 0; i < N; i++) {
			int diff = arr[i] - arr[start];
			if (arr[i] - arr[start] < L)
				continue;
			cnt++;
			start = i;
		}

		System.out.println(cnt);
	}
}
