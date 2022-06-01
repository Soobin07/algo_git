package beakjoon.silver;

import java.util.Scanner;

public class Q14888 {
	static int N, max, min;
	static int[] op, cnt, num;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		N = sc.nextInt();
		num = new int[N]; // 숫자
		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		}
		op = new int[4]; // 연산자
		for (int i = 0; i < op.length; i++) {
			op[i] = sc.nextInt();
		}

		perm(0, num[0]);
		
		System.out.println(max);
		System.out.println(min);
	}

	private static void perm(int idx, int sum) {
		if (idx == N-1) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
		}

		for (int i = 0; i < 4; i++) {
			if (op[i] > 0) {
				op[i]--;
				int newSum = getCalc(i, sum, num[idx + 1]);
				perm(idx+1, newSum);
				op[i]++;
			}
		}
	}

	private static int getCalc(int op, int sum, int num) {
		if (op == 0) {
			return sum + num;
		} else if (op == 1) {
			return sum - num;
		} else if (op == 2) {
			return sum * num;
		} else {
			return sum / num;
		}
	}

}
