package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2467 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] arr = new long[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		long[] ans = new long[3];
		ans[0] = Long.MAX_VALUE;
		int start = 0;
		int end = N - 1;
		while (true) {
			if (start >= end)
				break;
			if (arr[start] + arr[end] == 0) {
				// 0이면 이게 답임. 더 안찾아도 괜찮다.
				ans[0] = 0;
				ans[1] = arr[start];
				ans[2] = arr[end];
				break;
			}
			// 0이 아닌 경우
			if (ans[0] > Math.abs(arr[start] + arr[end])) {
				// 현재 있는 차 보다 현재 차가 더 작다? => 바꾼다!
				ans[0] = Math.abs(arr[start] + arr[end]);
				ans[1] = arr[start];
				ans[2] = arr[end];
			}
			// 다음 수 정하는 방법은?
			// 한칸씩 앞으로 간 것과 현재 수를 비교해서 더한 수가 더 작은 쪽을 쓴다
			if (Math.abs(arr[start] + arr[end - 1]) > Math.abs(arr[start + 1] + arr[end])) {
				start++;
			} else {
				end--;
			}
		}
		System.out.println(ans[1] + " " + ans[2]);
	}
}
