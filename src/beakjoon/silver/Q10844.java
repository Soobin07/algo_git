package beakjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

public class Q10844 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		// i개의 숫자, j로 끝나는 숫자의 갯수
		long[][] arr = new long[N + 1][10];
		Arrays.fill(arr[1], 1);
		arr[1][0] = 0;

		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 0)
					arr[i][j] = arr[i - 1][1];
				else if (j == 9)
					arr[i][j] = arr[i - 1][8];
				else
					arr[i][j] = (arr[i - 1][j - 1] + arr[i - 1][j + 1]) % 1_000_000_000;
			}
		}

		long ans = 0;
		for (int i = 0; i <= 9; i++) {
			ans= (ans + arr[N][i]) % 1_000_000_000;
		}

		System.out.println(ans % 1_000_000_000);
	}
}
