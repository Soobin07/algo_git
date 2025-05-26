package beakjoon.bronze;

import java.util.Scanner;

public class Q31403 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		String B = sc.next();
		String C = sc.next();

		int i_A = Integer.parseInt(A);
		int i_B = Integer.parseInt(B);
		int i_C = Integer.parseInt(C);
		int i_AB = Integer.parseInt(A + B);

		System.out.println(i_A + i_B - i_C);
		System.out.println(i_AB - i_C);
	}
}
