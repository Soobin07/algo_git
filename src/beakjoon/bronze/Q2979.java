package beakjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2979 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// 1분당 1대 a원, 2대 b원, 3대 c원
		st = new StringTokenizer(br.readLine());

		int[] costs = new int[4];
		for (int i = 1; i <= 3; i++) {
			costs[i] = Integer.parseInt(st.nextToken());
		}

		boolean[][] times = new boolean[3][101];
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			for (int j = start; j < end; j++) {
				times[i][j] = true;
			}
		}

		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			int cnt = 0;
			for (int j = 0; j < 3; j++) {
				if (times[j][i]) {
					cnt++;
				}
			}
			sum += (costs[cnt] * cnt) ;
		}

		System.out.println(sum);
	}
}
