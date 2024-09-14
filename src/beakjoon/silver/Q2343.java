package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//기타 레슨
public class Q2343 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// 강의의 수 N, 블루레이 M
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 강의 길이 배열 가져오기
		st = new StringTokenizer(br.readLine());
		// 강의 길이 배열
		int[] arr = new int[N];
		// 가장 긴 강의 길이
		int max = 0;
		// 전체 강의 길이 (최대 100000 * 10000 = 10억 = int범위)
		int sum = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
			sum += arr[i];
		}

		// 블루레이 최소 크기 찾기
		int start = max;
		int end = sum;
		while (start <= end) {
			int cd_cnt = 0;
			int tmp_sum = 0;
			int mid = (start + end) / 2;
			for (int i = 0; i < N; i++) {
				// 한장 다 찼으면
				if (tmp_sum + arr[i] > mid) {
					tmp_sum = 0;
					cd_cnt += 1;
				}
				tmp_sum += arr[i];
			}

			if (tmp_sum > 0)
				cd_cnt++;

			// cd 갯수 확인
			// 갯수 부족하면 용량 더 작게
			if (cd_cnt <= M)
				end = mid - 1;
			else
				start = mid + 1;
		}

		System.out.println(start);
	}
}
