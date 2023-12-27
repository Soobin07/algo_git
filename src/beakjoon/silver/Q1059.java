package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//좋은 구간
public class Q1059 {
	/*
	 * 1. 제외 해야 하는 정수 집합 S를 받은 후 숫자 크기대로 Sort한다 2. S에서 반드시 포함되어야 하는 숫자 n이 들어있는 구간을
	 * 확인한다 3. 구간의 가장 작은 숫자를 시작으로, n이 들어있게 A:B 구간을 만들어 CNT 한다
	 */

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int L = Integer.parseInt(br.readLine());
		int[] arr = new int[L];

		// 답
		int cnt = 0;

		// ARRAY S 받기
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < L; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// S Sort
		Arrays.sort(arr);

		// n 받기
		int n = Integer.parseInt(br.readLine());

		// S에서 n이 들어있는 구간. (n 보다 작은 숫자 중 가장 큰 숫자)
		int small_idx = -1;
		boolean flag = false;
		for (int i = 0; i < L; i++) {
			if (n < arr[i]) {
				break;
			}
			if (n == arr[i]) {
				flag = true;
				break;
			}
			small_idx = i;
		}

		// S 안에 n이 들어있으면 아무것도 만들 수 없다
		// n이 가장 큰 수보다 크거나 같으면 아무 것도 할 수 없다
		if (!flag && small_idx != L - 1) {
			int small = 0;
			int big = 0;
			// 가장 작은 것 보다 작으면?
			if (small_idx == -1) {
				small = 0;
				big = arr[0];
			} else {
				small = arr[small_idx];
				big = arr[small_idx + 1];
			}

			// 시작점
			for (int s = small + 1; s <= n; s++) {
				// 끝점
				for (int b = n; b < big; b++) {
					if (s == b)
						continue;
					cnt++;
				}
			}
		}

		System.out.println(cnt);
	}
}
