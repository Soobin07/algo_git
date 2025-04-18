package beakjoon.bronze;

import java.util.Scanner;

public class Q17618 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			String tmp = String.valueOf(i);
			char[] ch = tmp.toCharArray();
			int sum = 0;
			for (char c : ch) {
				sum += (c - '0');
			}
			if (i % sum == 0) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
