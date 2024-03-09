package beakjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//주사위 게임
public class Q2476 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		// 1~6 주사위 3개
		/*
		 * 상금 1. 같은 눈 3개 => 10000 + (같은눈)*1000원 2. 같은 눈 2개 => 1000 + (같은눈)*100원 3. else
		 * => 가장 큰 눈 * 100원
		 */

		// 가장 많은 상금을 받은 사람의 상금 출력
		int N = Integer.parseInt(br.readLine()); // 참여 사람
		int[] arr = new int[3]; // 각 사람이 던진 주사위 눈
		int max = 0; // 가장 많은 상금을 받은 사람의 상금
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			// 주사위 확인
			for (int j = 0; j < 3; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			// 주사위 정렬
			Arrays.sort(arr);
			int match = 0;
			int same = 0;
			// 몇개 같은지 확인
			if (arr[0] == arr[1]) {
				if (arr[1] == arr[2])
					match = 3;
				else
					match = 2;
				same = arr[0];
			} else {
				if (arr[1] == arr[2]) {
					match = 2;
					same = arr[1];
				} else {
					match = 1;
					same = arr[2]; // 가장 큰 눈
				}
			}

			// 상금 계산
			int gold = 0;
			if (match == 3) {
				gold = 10000 + same * 1000;
			} else if (match == 2) {
				gold = 1000 + same * 100;
			} else {
				gold = same * 100;
			}

			max = Math.max(max, gold);
		}

		System.out.println(max);
	}
}
