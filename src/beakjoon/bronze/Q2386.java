package beakjoon.bronze;

import java.util.Scanner;

public class Q2386 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		while (!str.equals("#")) {
			char c = str.charAt(0);
			str = str.substring(2, str.length());

			int[] cnt = new int[26];
			for (int i = 0; i < str.length(); i++) {
				char h = str.charAt(i);
				if (h >= 'a' && h <= 'z') {
					cnt[h - 'a']++;
				} else if (h >= 'A' && h <= 'Z') {
					cnt[h - 'A']++;
				}
			}
			System.out.println(c + " " + cnt[c - 'a']);
			str = sc.nextLine();
		}
	}
}
