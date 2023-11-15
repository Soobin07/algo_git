package beakjoon.bronze;

import java.util.Scanner;

public class Q19532 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		int e = sc.nextInt();
		int f = sc.nextInt();

		for (int x = 0; x <= 999; x++) {
			for (int y = 0; y <= 999; y++) {
				int X = x;
				int Y = y;
				if (a * X + b * Y == c && d * X + e * Y == f) {
					System.out.println(X + " " + Y);
					return;
				}
				X *= -1;
				if (a * X + b * Y == c && d * X + e * Y == f) {
					System.out.println(X + " " + Y);
					return;
				}
				Y *= -1;
				if (a * X + b * Y == c && d * X + e * Y == f) {
					System.out.println(X + " " + Y);
					return;
				}
				X *= -1;
				if (a * X + b * Y == c && d * X + e * Y == f) {
					System.out.println(X + " " + Y);
					return;
				}
			}
		}
	}
}
