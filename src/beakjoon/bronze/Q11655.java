package beakjoon.bronze;

import java.util.Scanner;

//ROT13
public class Q11655 {
	public static void main(String[] args) {
		// 알파벳 대문자, 소문자 13개 뒤로 넘기기
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();

		String str = sc.nextLine();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c >= 'a' && c <= 'z') {
				c += 13;
				if (c > 'z') {
					c -= ('z' - 'a' + 1);
				}
			} else if (c >= 'A' && c <= 'Z') {
				c += 13;
				if (c > 'Z') {
					c -= ('Z' - 'A' + 1);
				}
			}
			sb.append(c);
		}
		System.out.print(sb.toString());
	}
}
