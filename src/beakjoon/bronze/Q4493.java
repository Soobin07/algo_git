package beakjoon.bronze;

import java.util.Scanner;

public class Q4493 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int p1 = 0;
			int p2 = 0;
			for (int n = 0; n < N; n++) {
				String[] ch = { sc.next(), sc.next() };
				if (ch[0].equals(ch[1])) {
					continue;
				}
				if (ch[0].equals("R")) {
					if (ch[1].equals("P")) {
						p2++;
					} else {
						p1++;
					}
				} else if (ch[0].equals("P")) {
					if (ch[1].equals("R")) {
						p1++;
					} else {
						p2++;
					}
				} else {
					if (ch[1].equals("P")) {
						p1++;
					} else {
						p2++;
					}
				}
			}
			if (p1 > p2)
				System.out.println("Player 1");
			else if (p1 == p2) {
				System.out.println("TIE");
			} else {
				System.out.println("Player 2");
			}
		}

	}
}
