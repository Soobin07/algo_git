package beakjoon.bronze;

import java.util.Scanner;

public class Q2985 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		// 앞쪽에서 등호
		if (a == (b + c)) {
			System.out.println(a + "=" + b + "+" + c);
			return;
		} else if (a == (b - c)) {
			System.out.println(a + "=" + b + "-" + c);
			return;
		} else if (a == (b * c)) {
			System.out.println(a + "=" + b + "*" + c);
			return;
		} else if (a == (b / c)) {
			System.out.println(a + "=" + b + "/" + c);
			return;
		} else if ((a + b) == c) {
			System.out.println(a + "+" + b + "=" + c);
			return;
		} else if ((a - b) == c) {
			System.out.println(a + "-" + b + "=" + c);
			return;
		} else if ((a * b) == c) {
			System.out.println(a + "*" + b + "=" + c);
			return;
		} else if ((a / b) == c) {
			System.out.println(a + "/" + b + "=" + c);
			return;
		}
	}
}
