package beakjoon.silver;

import java.util.Scanner;

public class Q9656 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		System.out.println(N % 2 == 0 ? "SK" : "CY");
	}
}
