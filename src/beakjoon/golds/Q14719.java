package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//빗물
public class Q14719 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		int[] arr = new int[W + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= W; i++) {
			arr[i] = Math.min(Integer.parseInt(st.nextToken()), H);
		}

		int start = 1;
		int end = 2;
		long sum = 0;
		// 넓이 3부터 가둘 수 있음
		// 앞에서부터 높이 가져온다
		while (true) {
			if (end >= W)
				break;
			for (int i = start; i <= W; i++) {
				// 시작보다 더 큰 벽 발견 -> 시작을 바꿔줄 차례
				if (arr[start] <= arr[i]) {
					// 시작 ~ 현재 벽 사이의 모든 벽 위에 올라갈 물의 양
					for (int j = start; j < i; j++) {
						sum += (arr[start] - arr[j]);
					}
					// 현재 벽을 시작으로, 다음 벽들 확인
					start = i;
					end = i + 1;
					continue;
				}
				// start보다 뒤에 있으면서, 그 중 가장 큰 친구를 찾아라
				if (arr[end] < arr[i]) {
					end = i;
				}
			}
			// 끝에 도착하면 start, end를 이용하여 사이 모든 블록 위 빗물 양을 찾는다
			for (int i = start; i <= Math.min(end, W); i++) {
				sum += Math.max(0, (arr[Math.min(end, W)] - arr[i]));
			}
			// end 부터 다시 시작한다.
			start = end;
			end = start + 1;
		}

		System.out.println(sum);
	}
}
