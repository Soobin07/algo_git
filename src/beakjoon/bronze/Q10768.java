package beakjoon.bronze;

import java.util.Scanner;

public class Q10768 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int month = sc.nextInt();
		int day = sc.nextInt();

		if (month > 2) {
			System.out.println("After");
			return;
		} else if (month == 1) {
			System.out.println("Before");
			return;
		}

		if (day > 18) {
			System.out.println("After");
			return;
		} else if (day == 18) {
			System.out.println("Special");
			return;
		}
		System.out.println("Before");
	}
}
