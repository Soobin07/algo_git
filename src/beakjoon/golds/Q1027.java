package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1027 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int max = 0;

		// 좌, 우 기울기 구하기
		// 가로선 기울기 = 0 , / = +, \ = -
		for (int n = 0; n < N; n++) {
			int cnt = 0;
			double tmp = 0;

			// 좌 (바로 옆에 것 보다는 기울기가 더 작아야 보인다)
			for (int i = n - 1; i >= 0; i--) {
				double s = (double) (arr[n] - arr[i]) / (n - i);
				if (i == n - 1 || tmp > s) {
					cnt++;
					tmp = s;
				}
			}

			// 우 (바로 옆의 것 보다는 더 커야 보인다)
			for (int i = n + 1; i < N; i++) {
				double s = (double) (arr[n] - arr[i]) / (n - i);
				if (i == n + 1 || tmp < s) {
					cnt++;
					tmp = s;
				}
			}

			max = Math.max(max, cnt);
		}
		System.out.println(max);
	}
}
