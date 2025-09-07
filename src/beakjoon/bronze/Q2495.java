package beakjoon.bronze;

import java.util.Scanner;

public class Q2495 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 0; t < 3; t++) {
			String str = sc.next();

			int max = 1;
			int now = 1;
			for (int i = 1; i < str.length(); i++) {
				if (str.charAt(i - 1) == str.charAt(i)) {
					now++;
				} else {
					max = Math.max(max, now);
					now = 1;
				}
			}
			max = Math.max(max, now);

			System.out.println(max);
		}
	}
}
