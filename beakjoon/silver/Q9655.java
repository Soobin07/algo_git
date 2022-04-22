package beakjoon.silver;

import java.util.Scanner;

public class Q9655 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String win = "SK";
		if((N/3 + N%3)%2 == 0) {
			win = "CY";
		}
		System.out.println(win);
	}
}
