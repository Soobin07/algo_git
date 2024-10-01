package beakjoon.bronze;

import java.util.Scanner;

//배수 찾기
public class Q4504 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int next = 0;
		while ((next = sc.nextInt()) != 0) {
			System.out.println((next % n) != 0 ? next + " is NOT a multiple of " + n + "."
					: next + " is a multiple of " + n + ".");
		}
	}
}
