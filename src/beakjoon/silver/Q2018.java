package beakjoon.silver;

import java.util.Scanner;

public class Q2018 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int cnt = 0;
		int start = 1;
		int end = 1;

		while (start <= N && end <= N) {
			long remain = N;
			for (int i = start; i <= end; i++) {
				remain -= i;
			}
			if (remain == 0) {
				cnt++;
				start++;
			} else if (remain > 0) {
				end++;
			} else if (remain < 0) {
				start++;
			}
		}

		System.out.println(cnt);
	}
}
