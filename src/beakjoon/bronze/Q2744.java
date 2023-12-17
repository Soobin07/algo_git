package beakjoon.bronze;

import java.util.Scanner;

public class Q2744 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();

		int gap = 'a' - 'A';

		String str = sc.nextLine();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c >= 'A' && c <= 'Z') {
				sb.append((char) (c + gap));
			} else {
				sb.append((char) (c - gap));
			}
		}
		System.out.println(sb.toString());
	}
}
