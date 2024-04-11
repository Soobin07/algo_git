package beakjoon.platinum;

import java.util.ArrayList;
import java.util.Scanner;

public class Q1786 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String T = sc.nextLine();
		String P = sc.nextLine();

		int[] table = makeTable(P);
		int l1 = T.length();
		int l2 = P.length();

		if (l1 >= l2) {
			int cnt = 0;
			ArrayList<Integer> start = new ArrayList<>();
			int idx = 0;
			for (int i = 0; i < l1; i++) {
				while (idx > 0 && T.charAt(i) != P.charAt(idx)) {
					idx = table[idx - 1];
				}
				if (T.charAt(i) == P.charAt(idx)) {
					if (idx == l2 - 1) {
						idx = table[idx];
						cnt++;
						start.add(i - l2 + 2);
					} else {
						idx++;
					}
				}
			}

			System.out.println(cnt);
			for (int ans : start) {
				System.out.print(ans + " ");
			}
		} else {
			System.out.println(0);
		}
	}

	static int[] makeTable(String P) {
		int l1 = P.length();
		int[] table = new int[l1];

		int idx = 0;
		for (int i = 1; i < l1; i++) {
			while (idx > 0 && P.charAt(i) != P.charAt(idx)) {
				idx = table[idx - 1];
			}
			if (P.charAt(i) == P.charAt(idx)) {
				idx++;
				table[i] = idx;
			}
		}
		return table;
	}
}
