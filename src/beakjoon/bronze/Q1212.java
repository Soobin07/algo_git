package beakjoon.bronze;

import java.util.Scanner;

public class Q1212 {
	public static void main(String[] args) {
		// 8진수 주어지면
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		if (str.charAt(0) - '0' == 0) {
			System.out.println("0");
		} else {
			if (str.charAt(0) - '0' == 1) {
				System.out.print("1");
			} else if (str.charAt(0) - '0' == 2) {
				System.out.print("10");
			} else if (str.charAt(0) - '0' == 3) {
				System.out.print("11");
			} else if (str.charAt(0) - '0' == 4) {
				System.out.print("100");
			} else if (str.charAt(0) - '0' == 5) {
				System.out.print("101");
			} else if (str.charAt(0) - '0' == 6) {
				System.out.print("110");
			} else if (str.charAt(0) - '0' == 7) {
				System.out.print("111");
			}
			for (int i = 1; i < str.length(); i++) {
				int ch = str.charAt(i) - '0';
				if (ch == 0) {
					System.out.print("000");
				} else if (ch == 1) {
					System.out.print("001");
				} else if (ch == 2) {
					System.out.print("010");
				} else if (ch == 3) {
					System.out.print("011");
				} else if (ch == 4) {
					System.out.print("100");
				} else if (ch == 5) {
					System.out.print("101");
				} else if (ch == 6) {
					System.out.print("110");
				} else if (ch == 7) {
					System.out.print("111");
				}
			}
		}
	}
}
