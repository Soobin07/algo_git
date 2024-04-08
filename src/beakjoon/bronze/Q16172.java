package beakjoon.bronze;

import java.util.Scanner;

public class Q16172 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String origin = sc.next();
		String pattern = sc.next();

		System.out.println(KMP(origin, pattern));
	}

	static int KMP(String origin, String pattern) {
		int[] table = makeTable(pattern);
		int l1 = origin.length();
		int l2 = pattern.length();

		int idx = 0;
		for (int i = 0; i < l1; i++) {
			if(origin.charAt(i) >= '0' && origin.charAt(i) <= '9')
				continue;
			while (idx > 0 && origin.charAt(i) != pattern.charAt(idx)) {
				idx = table[idx - 1];
			}
			if (origin.charAt(i) == pattern.charAt(idx)) {
				if (idx == l2 - 1) {
					idx = table[idx];
					return 1;
				} else {
					idx += 1;
				}
			}
		}

		return 0;
	}

	static int[] makeTable(String pattern) {
		int l1 = pattern.length();
		int[] table = new int[l1];

		int idx = 0;

		for (int i = 1; i < l1; i++) {
			while (idx > 0 && pattern.charAt(i) != pattern.charAt(idx)) {
				idx = table[idx - 1];
			}
			if (pattern.charAt(i) == pattern.charAt(idx)) {
				idx++;
				table[i] = idx;
			}
		}

		return table;
	}

}
