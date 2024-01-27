package beakjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

public class Q9184 {
	static int[][][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();

		arr = new int[21][21][21];
		// 셋 중 1이 0 이하일 때 = 1;
		// 이하일 때는 0으로 처리
		// a = 0 -> 1
		for (int i = 0; i < 21; i++) {
			Arrays.fill(arr[0][i], 1);
		}
		// b = 0 -> 1
		for (int i = 0; i < 21; i++) {
			Arrays.fill(arr[i][0], 1);
		}
		// c = 0 -> 1
		for (int i = 0; i < 21; i++) {
			for (int j = 0; j < 21; j++) {
				arr[i][j][0] = 1;
			}
		}
		// 셋 중 1이 20일 때 = w(20,20,20) => 넘으면 돌리기 (맵 밖 처리 처럼)
		// a<b<c일 때
		for (int i = 1; i < 21; i++) {
			for (int j = 1; j < 21; j++) {
				for (int k = 1; k < 21; k++) {
					if (i < j && j < k) {
						arr[i][j][k] = arr[i][j][k - 1] + arr[i][j - 1][k - 1] - arr[i][j - 1][k];
					} else {
						arr[i][j][k] = arr[i - 1][j][k] + arr[i - 1][j - 1][k] + arr[i - 1][j][k - 1]
								- arr[i - 1][j - 1][k - 1];
					}
				}
			}
		}

		while (!(A == B && B == C && C == -1)) {
			int tmp_a = A;
			int tmp_b = B;
			int tmp_c = C;

			if (A <= 0 || B <= 0 || C <= 0) {
				tmp_a = 0;
				tmp_b = 0;
				tmp_c = 0;
			} else if (A > 20 || B > 20 || C > 20) {
				tmp_a = 20;
				tmp_b = 20;
				tmp_c = 20;
			}

			sb.append("w(" + A + ", " + B + ", " + C + ") = " + arr[tmp_a][tmp_b][tmp_c] + "\n");

			A = sc.nextInt();
			B = sc.nextInt();
			C = sc.nextInt();
		}

		System.out.print(sb.toString());
	}

	static int w(int a, int b, int c) {
		System.out.printf("now : w(%d, %d, %d)\n", a, b, c);
		if (a <= 0 || b <= 0 || c <= 0)
			return 1;
		if (a > 20 || b > 20 || c > 20)
			return w(20, 20, 20);
		if (a < b && b < c)
			return w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
		return w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
	}

}
