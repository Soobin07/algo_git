package beakjoon.silver;

import java.util.Scanner;
import java.util.Stack;

public class Q17952 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		Stack<int[]> times = new Stack<>();
		int sum = 0;
		for (int i = 0; i < N; i++) {
			int plag = sc.nextInt();
			if (plag != 0) {
				int A = sc.nextInt();
				int T = sc.nextInt();
				times.add(new int[] { A, T });
			}

			if (times.isEmpty())
				continue;

			int[] tmp = times.pop();
			tmp[1]--;
			if (tmp[1] == 0) {
				sum += tmp[0];
				continue;
			}
			times.add(tmp);
		}

		System.out.println(sum);
	}
}
