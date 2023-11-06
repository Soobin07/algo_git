package beakjoon.silver;

import java.util.Scanner;

public class Q10974 {
	static int[] select;
	static boolean[] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		select = new int[N + 1];
		visit = new boolean[N + 1];

		make(1, N);
	}

	static void make(int sel, int N) {
		if (sel > N) {
			for (int i = 1; i <= N; i++) {
				System.out.print(select[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				select[sel] = i;
				make(sel + 1, N);
				visit[i] = false;
			}
		}
	}
}
