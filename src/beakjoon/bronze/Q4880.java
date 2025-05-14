package beakjoon.bronze;

import java.util.Scanner;

public class Q4880 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a1 = sc.nextInt();
		int a2 = sc.nextInt();
		int a3 = sc.nextInt();

		while (a1 != 0 || a2 != 0 || a3 != 0) {
			if (1.0D * a1 / a2 == 1.0D * a2 / a3) {
				System.out.println("GP " + a3 * (a3 / a2));
			}
			if (a1 - a2 == a2 - a3) {
				System.out.println("AP " + (a3 + a2 - a1));
			}

			a1 = sc.nextInt();
			a2 = sc.nextInt();
			a3 = sc.nextInt();
		}
	}
}
