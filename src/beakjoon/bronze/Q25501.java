package beakjoon.bronze;

import java.util.Scanner;

public class Q25501 {
	static int ans;

	public static int recursion(String s, int l, int r) {
		ans++;
		if (l >= r)
			return 1;
		else if (s.charAt(l) != s.charAt(r))
			return 0;
		else
			return recursion(s, l + 1, r - 1);
	}

	public static int isPalindrome(String s) {
		return recursion(s, 0, s.length() - 1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			String str_ = sc.next();
			ans = 0;
			System.out.println(isPalindrome(str_) + " " + ans);
		}
	}
}
