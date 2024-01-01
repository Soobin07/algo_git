package beakjoon.silver;

import java.util.Scanner;

//문자열
public class Q1120 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String A = sc.next();
		String B = sc.next();

		// A와 B가 얼마나 일치하는가를 확인한다 (나머지는 앞뒤로 붙여서 똑같아졌다고 가정)

		int ans = B.length();
		// B의 시작지점
		for (int i = 0; i < B.length() - A.length() + 1; i++) {
			int tmp = 0;
			for (int j = 0; j < A.length(); j++) {
				if (A.charAt(j) != B.charAt(i + j))
					tmp++;
			}
			ans = Math.min(ans, tmp);
		}

		System.out.println(ans);
	}
}
