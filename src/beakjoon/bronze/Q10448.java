package beakjoon.bronze;

import java.util.Scanner;

public class Q10448 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] T = new int[50];
		for (int i = 1; i < T.length; i++) {
			T[i] = T[i - 1] + i;
		}

		int TC = sc.nextInt();
		outer: while (TC-- > 0) {
			int tc = sc.nextInt();
			for (int i = 1; i < T.length; i++) {
				for (int j = 1; j < T.length; j++) {
					for (int k = 1; k < T.length; k++) {
						if (T[i] + T[j] + T[k] == tc) {
							System.out.println(1);
							continue outer;
						}
					}
				}
			}
			System.out.println(0);
		}
	}
}
