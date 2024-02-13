package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//창고 다각형
public class Q2304 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine()); // 기둥 갯수
		int[] map = new int[1001]; // 기둥 위치 + 길이, 0 제외

		// 가장 첫 기둥과 마지막 기둥
		int start = Integer.MAX_VALUE;
		int end = 0;

		// 기둥 위치 받기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken()); // 기둥 위치
			// 해당 위치에 해당 높이 기둥 있다
			map[L] = Integer.parseInt(st.nextToken());

			// 가장 첫 기둥과 마지막 기둥
			start = Math.min(start, L);
			end = Math.max(end, L);
		}

		int max = 0;
		// 앞에서부터 기둥 확인하며 뒤로 쭉
		for (int i = start; i <= end; i++) {
			int now = map[i];
			// 기준 위치 i 이후 기둥 중 더 큰 것이 있는지 확인
			boolean flag = true;
			for (int j = i + 1; j <= end; j++) {
				// 크거나 같은 기둥이 있으면
				if (map[i] <= map[j]) {
					// 사이 기둥을 모두 map[i]크기로 변경
					// 다음 i 는 j다
					for (; i < j - 1; i++) {
						map[i] = now;
					}
					map[i] = now;
					flag = false; // 뒤에 더 크거나 같은 것이 있었다.
					break;
				}
			}

			// 만약 뒤에 더 크거나 같은 것이 없었으면
			if (flag) {
				// 이게 제일 큰거였다 저장
				max = i;
				break;
			}
		}

		// 뒤에서 부터 기둥 확인하며 앞으로 (가장 큰 기둥 있었던 곳 까지)
		for (int i = end; i >= max; i--) {
			int now = map[i];
			boolean flag = true;
			for (int j = i - 1; j >= max; j--) {
				if (map[i] <= map[j]) {
					for (; i > j + 1; i--) {
						map[i] = now;
					}
					map[i] = now;
					flag = false;
					break;
				}
			}
		}

		// 다 더하기
		long sum = 0;
		for (int i = 0; i < 1001; i++) {
			sum += map[i];
		}
		System.out.println(sum);
	}
}
