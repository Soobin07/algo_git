package beakjoon.bronze;

import java.util.Scanner;

public class Q14470 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int D = sc.nextInt();
		int E = sc.nextInt();

		int cnt = 0;
		boolean isFrozen = A < 0 ? true : false;
		while (A != B) {
			if (A < 0) {
				A++;
				cnt += C;
			} else if (A == 0 && isFrozen) {
				isFrozen = false;
				cnt += D;
			} else {
				A++;
				cnt += E;
			}
		}

		System.out.println(cnt);
	}
}
