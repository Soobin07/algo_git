package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1806 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		int[] sum = new int[N];
		int tmp = 0;
		boolean flag = false;
		int ans = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			tmp += arr[i];
			sum[i] = tmp;
			if (arr[i] >= S)
				flag = true;
			if (tmp >= S && !flag && ans == 0)
				ans = i+1;
		}

		// 하나로 넘길 수 있다 하면 바로 넘어가기
		if (flag)
			System.out.println(1);
		// 불가능한가 확인
		else if (sum[N - 1] < S) {
			System.out.println(0);
		} else {
			// 전체 다 더하면 S 넘는다 => 가능하다.
			// 1. S보다 큰 곳 부터 시작 => ans
			int start = 0;
			int end = ans-1;
			// 2. 앞쪽 수를 빼고도 S보다 크면 ans를 update
			// 3. 뺀 후에 작아지면 end를 하나 늘려서 (N-1까지)
			while (true) {
				if (end <= start || end >= N || start < 0)
					break;
				if (sum[end] - sum[start] >= S) {
					ans = Math.min((end - start), ans);
					start++;
				} else {
					end++;
				}
			}
			System.out.println(ans);
		}
	}
}
