package beakjoon.silver;

import java.util.Scanner;

public class Q16953 {
	static boolean can;
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextLong();
		long B = sc.nextLong();
		find(A, B, 1);
		if (can)
			System.out.println(ans + 1);
		else
			System.out.println(-1);
	}

	static void find(long A, long B, int cnt) {
		if (can)
			return;
		// *2
		long tmp = A * 2;
		if (B > tmp)
			find(tmp, B, cnt + 1);
		else if (B == tmp) {
			can = true;
			ans = Math.min(ans, cnt);
			return;
		}
		// 뒤에 1자리 추가
		tmp = A * 10 + 1;
		if (B > tmp)
			find(tmp, B, cnt + 1);
		else if (B == tmp) {
			can = true;
			ans = Math.min(ans, cnt);
			return;
		}
	}
}
