package beakjoon.silver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Q1183 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] times = new int[N];
		int[] arriv = new int[N];
		ArrayList<Long> gap = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			times[i] = sc.nextInt();
			arriv[i] = sc.nextInt();

			long tmp = times[i] - arriv[i];
			gap.add(tmp);
		}

		Collections.sort(gap);

		int cnt = 1;
		if (gap.size() % 2 == 0) {
			int mid = gap.size() / 2;
			cnt = (int) (gap.get(mid) - gap.get(mid - 1) + 1);
		}

		System.out.println(cnt);
	}
}
