package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//게임을 만든 동준이
public class Q2847 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 레벨
		// 레벨을 클리어 할 때 주는 점수 증가
		// 1만큼 감소시키면 1
		// 점수를 내리는 것을 최소화

		// 점수 넣기
		int[] scores = new int[N];
		for (int i = 0; i < N; i++) {
			scores[i] = Integer.parseInt(br.readLine());
		}

		// 뒤에서부터 확인 -> 앞을 줄이자
		int minus = 0;
		for (int i = N - 2; i >= 0; i--) {
			if (scores[i] >= scores[i + 1]) {
				int gap = scores[i] - scores[i + 1] + 1;
				minus += gap;
				scores[i] -= gap;
			}
		}

		System.out.println(minus);
	}
}
