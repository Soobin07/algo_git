package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1107 {
	static boolean[] can_use_num;
	static int N, min_push;

	public static void main(String[] args) throws Exception {
		// 입출력 io 선언 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// 조건 받기
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		// 가장 작은 gap은 현재 위치에서 N까지 직접 올리고 내리는 숫자로 본다
		min_push = Math.abs(100 - N);

		// 만약 M이 0이면 ? 그냥 누르면 된다
		if (M == 0) {
			min_push = Math.min(min_push, (N + "").length());
		} else {
			
			// 사용할 수 없는 넘버 받기
			can_use_num = new boolean[10];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				can_use_num[Integer.parseInt(st.nextToken())] = true;
			}
			
			// N부터 하나씩 줄여간다
			int gap = 0;
			while (true) {
				boolean flag = false;
				// N보다 gap만큼 큰 수 확인
				String tmp = "" + (N + gap);
				for (int i = 0; i < tmp.length(); i++) {
					if (can_use_num[tmp.charAt(i) - '0']) {
						flag = true;
						break;
					}
				}
				if (!flag) {
					min_push = Math.min(min_push, gap + tmp.length());
				}
				// N보다 gap만큼 작은 수 확인
				// 단, 0보다 큰 경우에만 본다
				if (N - gap >= 0) {
					flag = false;
					tmp = "" + (N - gap);
					for (int i = 0; i < tmp.length(); i++) {
						if (can_use_num[tmp.charAt(i) - '0']) {
							flag = true;
							break;
						}
					}
					if (!flag) {
						min_push = Math.min(min_push, gap + tmp.length());
					}
				}

				// 만약 gap이 min_push보다 크면 +-버튼 누르는데만 횟수를 다 써야한다 => 그거 이하만 보자
				if (gap > min_push)
					break;
				// gap을 하나 늘려봅시다
				gap++;
			}
		}

		System.out.println(min_push);
	}
}
