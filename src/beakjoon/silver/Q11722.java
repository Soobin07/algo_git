package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//가장 긴 감소하는 부분수열
public class Q11722 {
	static int[] max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		// 수열 넣기
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 가장 긴 증가하는 부분수열을 반대로! (N부터 시작)
		max = new int[N + 1];
		int ans = 1;
		max[1] = arr[N - 1];
		for (int i = N - 2; i >= 0; i--) {
			if (max[ans] < arr[i]) {
				ans++;
				max[ans] = arr[i];
				continue;
			}
			int tmp = find(0, ans, arr[i]);
			if (tmp != -1)
				max[tmp] = arr[i];
		}
		System.out.println(ans);
	}

	static int find(int start, int end, int stad) {
		int mid = 0;
		while (end > start) {
			mid = (start + end) / 2;
			if (max[mid] < stad) {
				start = mid + 1;
			} else if (max[mid] > stad) {
				end = mid;
			} else {
				return -1;
			}
		}
		return end;
	}
}
