package beakjoon.bronze;

import java.util.Scanner;

public class Q4562 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		for (int n = 0; n < N; n++) {
			if (sc.nextInt() < sc.nextInt()) {
				System.out.println("NO BRAINS");
			} else {
				System.out.println("MMM BRAINS");
			}
		}
	}
}
