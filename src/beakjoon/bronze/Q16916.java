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

		int idx = 0; // 비교할 패턴문자의 글자 idx
		for (int i = 0; i < l1; i++) {
			// 패턴 글자가 한글자 이상 맞았고, 패턴 글자와 origin 글자가 틀릴 때
			while (idx > 0 && origin.charAt(i) != pattern.charAt(idx)) {
				idx = table[idx - 1]; // 다음 비교할 글자는 패턴문자의 몇번째 글자인지 정한다
			}
			// 패턴의 첫 글자일땐 무조건 origin의 i번째 글자와 비교!
			if (origin.charAt(i) == pattern.charAt(idx)) {
				// 패턴의 첫 글자와 origin의 i번째 글자가 같으면
				if (idx == l2 - 1) {// 패턴 문자의 마지막 글자인 경우
					idx = table[idx];
					return 1; // 전체 한바퀴 돈 거니까 패턴이 들어있는것!
				} else { // 다음 글자를 본다
					idx += 1;
				}
			}
			// => 둘이 다르면 다음 글자를 패턴의 첫 글자와 비교
		}
		return 0; // 없음
	}

	// idx에서 틀리면 다음번에 몇번째 글자부터 비교해야 하는지 확인하는 테이블
	static int[] makeTable(String pattern) {
		int n = pattern.length();
		int[] table = new int[n];

		int idx = 0;
		for (int i = 1; i < n; i++) { // 패턴문자 안에서 패턴 확인
			while (idx > 0 && pattern.charAt(i) != pattern.charAt(idx)) {
				// 패턴의 i번째 문자와 idx번째 문자가 다르면
				// 가장 최근까지 같았던 곳으로 이동해서 다시 비교
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
