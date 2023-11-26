package beakjoon.bronze;

import java.util.Scanner;

//둘 다 가능.
public class Q2745 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int N = sc.nextInt();

		/*
		int ans = 0;
		int now = 1;
		int len = str.length() - 1;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(len - i);
			if (ch >= '0' && ch <= '9') {
				ans += (ch - '0') * now;
			} else {
				ans += (10 + ch - 'A') * now;
			}
			now *= N;
		}
		System.out.println(ans);
		*/
		System.out.println(Integer.parseInt(str, N));
	}
}
