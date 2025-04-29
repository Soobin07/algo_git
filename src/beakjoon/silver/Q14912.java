package beakjoon.silver;

import java.util.Scanner;

public class Q14912 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int d = sc.nextInt();
		int[] cnt = new int[10];
		for (int i = 1; i <= n; i++) {
			String str = String.valueOf(i);
			for (int j = 0; j < str.length(); j++) {
				cnt[str.charAt(j) - '0']++;
			}
		}

		System.out.println(cnt[d]);
	}
}
