package beakjoon.silver;

import java.util.Scanner;

public class Q2417 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();

		long a = (long) Math.sqrt(n);
		System.out.println(Math.pow(a, 2) >= n ? a : (a + 1));
	}
}
