package beakjoon.bronze;

import java.util.Scanner;

public class Q11005 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 10진법수 N, B진법으로 바꿔 출력
		// 10진법 넘어가면 A:10 ~ Z : 35
		int n = sc.nextInt();
		int b = sc.nextInt();

		StringBuffer sb = new StringBuffer();
		while (true) {
			if (n == 0)
				break;
			int k = n % b;
			n /= b;

			if (k >= 10) {
				// A가 10..
				sb.append((char) ('A' + (k - 10)));
			} else {
				sb.append(k);
			}
		}
		System.out.println(sb.toString());
	}
}
