package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q18427 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N + 1][H + 1];
		List<Integer>[] block = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			block[i] = new ArrayList<>();
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				block[i].add(Integer.parseInt(st.nextToken()));
			}
		}

		for (int i = 0; i <= N; i++) {
			arr[i][0] = 1;
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= H; j++) {
				for (Integer intg : block[i]) {
					if (j >= intg) {
						arr[i][j] += arr[i - 1][j - intg];
						arr[i][j] %= 10007;
					}
				}
				arr[i][j] += arr[i - 1][j];
				arr[i][j] %= 10007;
			}
		}
		System.out.println(arr[N][H]);
	}
}
