package beakjoon.silver;

import java.util.*;

class Q2564 {
	static int C, R, N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		C = sc.nextInt();
		R = sc.nextInt();
		N = sc.nextInt();

		int[][] map = new int[N][2];
		for (int i = 0; i < N; i++) {
			map[i] = getDist(sc.nextInt(), sc.nextInt());
		}

		int[] dong = getDist(sc.nextInt(), sc.nextInt());

		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += getDiff(map[i], dong);
		}

		System.out.print(sum);
	}

	public static int[] getDist(int d, int length) {
		int[] arr = new int[2];
		int other = 0;
		switch (d) {
		case 2:
			other = R;
			break;
		case 4:
			other = C;
			break;
		}
		if ((d - 1) / 2 >= 1) {
			arr[0] = length;
			arr[1] = other;
		} else {
			arr[0] = other;
			arr[1] = length;
		}
		return arr;
	}

	public static int getDiff(int[] A, int[] B) {
		int sum = 0;
		int r = Math.abs(A[0] - B[0]);
		int c = Math.abs(A[1] - B[1]);
		int[] arr = new int[4];
		if (r == R) {
			arr[0] = A[1];
			arr[1] = B[1];
			arr[2] = C - A[1];
			arr[3] = C - B[1];
		} else if (c == C) {
			arr[0] = A[0];
			arr[1] = B[0];
			arr[2] = R - A[0];
			arr[3] = R - B[0];
		}
		Arrays.sort(arr);
		sum += (arr[0] * 2);
		sum += (r + c);

		return sum;
	}
}