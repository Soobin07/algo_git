package beakjoon.bronze;

import java.util.Scanner;

public class Q6378 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();

		while (!str.equals("0")) {
			String tmp = str;
			while (tmp.length() > 1) {
				int sum = 0;
				for (int i = 0; i < tmp.length(); i++) {
					sum += tmp.charAt(i) - '0';
				}
				tmp = String.valueOf(sum);
			}
			System.out.println(tmp);
			str = sc.next();
		}
	}
}
