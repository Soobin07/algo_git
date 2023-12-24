package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1049 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 0 : 패키지, 1 : 낱개
		int[][] arr = new int[M][2];

		int pack = Integer.MAX_VALUE;
		int one = Integer.MAX_VALUE;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());

			pack = Math.min(pack, arr[i][0]);
			one = Math.min(one, arr[i][1]);
		}

		if (pack > one * 6) {
			pack = one * 6;
		}

		int cost = (N / 6) * pack + Math.min(pack, one * (N % 6));
		System.out.println(cost);
	}
}
