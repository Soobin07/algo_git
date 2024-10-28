package beakjoon.bronze;

import java.util.Scanner;

public class Q2484 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int max = 0;
		outer: for (int i = 0; i < N; i++) {
			int[] cnt = new int[7];
			for (int j = 0; j < 4; j++) {
				cnt[sc.nextInt()]++;
			}

			for (int j = 6; j >= 0; j--) {
				if (cnt[j] == 4) {
					max = Math.max(max, (50000 + j * 5000));
					continue outer;
				} else if (cnt[j] == 3) {
					max = Math.max(max, (10000 + j * 1000));
					continue outer;
				} else if (cnt[j] == 2) {
					for (int k = 1; k <= 6; k++) {
						if (k != j && cnt[k] == 2) {
							max = Math.max(max, (2000 + j * 500 + k * 500));
							continue outer;
						}
					}
					max = Math.max(max, (1000 + j * 100));
				}
			}
			for (int j = 6; j >= 0; j--) {
				if (cnt[j] > 0) {
					max = Math.max(max, j * 100);
					continue outer;
				}
			}
		}
		System.out.println(max);
	}
}
