package beakjoon.bronze;

import java.util.Scanner;

public class Q5586 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();

		int cntj = 0;
		int cnti = 0;

		for (int i = 0; i < str.length() - 2; i++) {
			String tmp = str.substring(i, i + 3);
			if (tmp.equals("JOI")) {
				cntj++;
			} else if (tmp.equals("IOI")) {
				cnti++;
			}
		}
		System.out.println(cntj);
		System.out.println(cnti);
	}
}
