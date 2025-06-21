package beakjoon.silver;

import java.util.Scanner;

public class Q1531 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[][] map = new int[100][100];
		for (int i = 0; i < N; i++) {
			int lx = sc.nextInt() - 1;
			int ly = sc.nextInt() - 1;
			int rx = sc.nextInt() - 1;
			int ry = sc.nextInt() - 1;

			for (int x = lx; x <= rx; x++) {
				for (int y = ly; y <= ry; y++) {
					map[x][y] += 1;
				}
			}
		}

		int cnt = 0;
		for (int x = 0; x < 100; x++) {
			for (int y = 0; y < 100; y++) {
				if(map[x][y] > M) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}
}
