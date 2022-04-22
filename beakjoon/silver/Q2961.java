package beakjoon.silver;

import java.util.Scanner;

public class Q2961 {
	static long[][] list;
	static int N;
	static long min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		min = Long.MAX_VALUE;
		list = new long[N][2];
		for (int i = 0; i < N; i++) {
			list[i] = new long[] { sc.nextLong(), sc.nextLong() };
		}

		recur(0, 0, 1, 0);
		
		System.out.println(min);
	}

	static void recur(int index, int sidx, long sSum, long bSum) {
		if (index == N) {
			if (sidx != 0) {
				min = Math.min(min, Math.abs(bSum - sSum));
			}
			return;
		}
		
		recur(index+1, sidx, sSum, bSum);
		recur(index+1, sidx+1, sSum*list[index][0], bSum+list[index][1]);
	}
}
