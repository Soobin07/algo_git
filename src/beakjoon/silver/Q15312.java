package beakjoon.silver;

import java.util.Scanner;

public class Q15312 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// A~Z 각 글자의 획수 배열 (문제 힌트 그대로)
		int[] cnt = { 3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1 };

		String A = sc.next();
		String B = sc.next();
		int n = A.length();

		// 1) 교차 섞기: i < n 으로 반복해야 함
		int[] strokes = new int[2 * n];
		for (int i = 0; i < n; i++) {
			strokes[2 * i] = cnt[A.charAt(i) - 'A'];
			strokes[2 * i + 1] = cnt[B.charAt(i) - 'A'];
		}

		// 2) 인접합 반복: 길이 L → L-1 로 줄여가며
		while (strokes.length > 2) {
			int L = strokes.length;
			int[] next = new int[L - 1];
			for (int i = 0; i < L - 1; i++) {
				next[i] = (strokes[i] + strokes[i + 1]) % 10;
			}
			strokes = next;
		}

		// 3) 결과 출력: 0도 “0”으로 두 글자 모두 출력
		System.out.printf("%d%d\n", strokes[0], strokes[1]);
		sc.close();
	}
}