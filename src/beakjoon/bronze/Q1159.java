package beakjoon.bronze;

import java.util.Scanner;

//농구 경기
public class Q1159 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] cnt = new int[26];
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			String str = sc.next();
			cnt[str.charAt(0) - 'a']++;
		}

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < cnt.length; i++) {
			if (cnt[i] >= 5) {
				sb.append((char) (i + 'a'));
			}
		}
		if (sb.length() == 0) {
			sb.append("PREDAJA");
		}
		System.out.println(sb.toString());
	}
}
