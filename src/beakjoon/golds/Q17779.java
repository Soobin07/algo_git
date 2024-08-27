package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//게리맨더링2
public class Q17779 {
	static int N;
	static int[][] arr;
	static int total = 0;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		arr = new int[N][N];

		// input
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				total += arr[i][j];
			}
		}

		// 조건넣기
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				for (int d1 = 1; d1 < N; d1++) {
					for (int d2 = 1; d2 < N; d2++) {
						if (x + d1 + d2 >= N)
							continue;
						if (y - d1 < 0 || y + d2 >= N)
							continue;
						find(x, y, d1, d2);
					}
				}
			}
		}
		System.out.println(min);
	}

	static void find(int x, int y, int d1, int d2) {
		boolean[][] border = new boolean[N][N];
		// 경계
		for (int i = 0; i <= d1; i++) {
			border[x + i][y - i] = true;
			border[x + d2 + i][y + d2 - i] = true;
		}
		for (int i = 0; i <= d2; i++) {
			border[x + i][y + i] = true;
			border[x + d1 + i][y - d1 + i] = true;
		}

		int[] sum = new int[5];

		// 1구역
		for (int i = 0; i < x + d1; i++) {
			for (int j = 0; j <= y; j++) {
				if (border[i][j])
					break;
				sum[0] += arr[i][j];
			}
		}
		// 2구역
		for (int i = 0; i <= x + d2; i++) {
			for (int j = N - 1; j > y; j--) {
				if (border[i][j])
					break;
				sum[1] += arr[i][j];
			}
		}
		// 3구역
		for (int i = x + d1; i < N; i++) {
			for (int j = 0; j < y - d1 + d2; j++) {
				if (border[i][j])
					break;
				sum[2] += arr[i][j];
			}
		}
		// 4구역
		for (int i = x + d2 + 1; i < N; i++) {
			for (int j = N - 1; j >= y - d1 + d2; j--) {
				if (border[i][j])
					break;
				sum[3] += arr[i][j];
			}
		}
		// 5구역
		sum[4] = total;
		for (int i = 0; i < 4; i++) {
			sum[4] -= sum[i];
		}

		// 정렬
		Arrays.sort(sum);
		// 최대 최소 차
		min = Math.min(min, sum[4] - sum[0]);
	}
}
