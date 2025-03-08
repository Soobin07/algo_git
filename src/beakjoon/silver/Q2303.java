package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2303 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][5];
		for (int i = 0; i < N; i++) {
			String[] tmp = br.readLine().split(" ");
			for (int j = 0; j < 5; j++) {
				arr[i][j] = Integer.parseInt(tmp[j]);
			}
		}

		int max_idx = -1;
		int max_value = -1;
		for (int n = N - 1; n >= 0; n--) {
			for (int i = 0; i < 3; i++) {
				for (int j = i + 1; j < 4; j++) {
					for (int k = j + 1; k < 5; k++) {
						int sum = arr[n][i] + arr[n][j] + arr[n][k];
						sum %= 10;
						if (max_value < sum) {
							max_value = sum;
							max_idx = n;
						}
					}
				}
			}
		}

		System.out.println(max_idx + 1);
	}
}
