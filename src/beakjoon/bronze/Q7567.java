package beakjoon.bronze;

import java.util.Scanner;

//그릇
public class Q7567 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char ch = '0';
		int height = 0;

		for (int i = 0; i < str.length(); i++) {
			if (ch != str.charAt(i)) {
				height += 10;
			} else {
				height += 5;
			}
			ch = str.charAt(i);
		}

		System.out.println(height);
	}
}
