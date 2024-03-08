package beakjoon.bronze;

import java.util.Scanner;

//이상한 곱셈
public class Q1225 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String first = sc.next();
		String second = sc.next();

		long ans = 0;
		for (int i = 0; i < first.length(); i++) {
			int a = first.charAt(i) - '0';
			for (int j = 0; j < second.length(); j++) {
				ans += (a * (second.charAt(j) - '0'));
			}
		}
		
		System.out.println(ans);
	}
}
