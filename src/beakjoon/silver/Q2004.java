package beakjoon.silver;

import java.util.Scanner;

public class Q2004 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		long cnt5 = cnt_five(n) - cnt_five(n - m) - cnt_five(m);
		long cnt2 = cnt_two(n) - cnt_two(n - m) - cnt_two(m);

		System.out.println(Math.min(cnt5, cnt2));
	}

	static long cnt_five(int n) {
		int cnt = 0;
		while (n >= 5) {
			cnt += (n / 5);
			n /= 5;
		}
		return cnt;
	}

	static long cnt_two(int n) {
		int cnt = 0;
		while (n >= 2) {
			cnt += (n / 2);
			n /= 2;
		}
		return cnt;
	}
}
