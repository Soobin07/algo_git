package beakjoon.bronze;

import java.util.Scanner;

public class Q14582 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] g = new int[9];
		g[0] = sc.nextInt();
		for (int i = 1; i < g.length; i++) {
			int tmp = sc.nextInt();
			g[i] = g[i - 1] + tmp;
		}

		int[] h = new int[9];
		h[0] = sc.nextInt();
		for (int i = 1; i < h.length; i++) {
			int tmp = sc.nextInt();
			h[i] = h[i - 1] + tmp;
		}

		boolean isthat = g[0] > 0 ? true : false;
		for (int i = 1; i < 9; i++) {
			if (g[i] > h[i - 1]) {
				isthat = true;
			}
		}

		System.out.println(isthat ? "Yes" : "No");
	}
}
