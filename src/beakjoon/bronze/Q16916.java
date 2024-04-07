package beakjoon.bronze;

import java.util.Scanner;

//부분 문자열
public class Q16916 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.next();
		String P = sc.next();

		System.out.println(KMP(S, P));
	}

	static int KMP(String origin, String pattern) {
		int[] table = makeTable(pattern);
		int l1 = origin.length();
		int l2 = pattern.length();

		int idx = 0;
		for (int i = 0; i < l1; i++) {
			// 둘이 다르면 다음 같은 곳으로 가자고
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
		return 0; // 없음
	}

	static int[] makeTable(String pattern) {
		int n = pattern.length();
		int[] table = new int[n];

		int idx = 0;
		for (int i = 1; i < n; i++) {
			while (idx > 0 && pattern.charAt(i) != pattern.charAt(idx)) {
				idx = table[idx - 1];
			}
			// 문자 일치하면 다음에 여기서부터 시작하도록
			if (pattern.charAt(i) == pattern.charAt(idx)) {
				idx++;
				table[i] = idx;
			}
		}
		return table;
	}
}
