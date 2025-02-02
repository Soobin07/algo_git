package beakjoon.silver;

import java.util.ArrayList;
import java.util.Scanner;

public class Q2422 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		ArrayList[] list = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list[a].add(b);
			list[b].add(a);
		}

		int cnt = 0;
		for (int i = 1; i < N + 1; i++) {
			for (int j = i + 1; j < N + 1; j++) {
				if (list[j].contains(i))
					continue;
				for (int k = j + 1; k < N + 1; k++) {
					if (list[k].contains(i) || list[k].contains(j))
						continue;
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
