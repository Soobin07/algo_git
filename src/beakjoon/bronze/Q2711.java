package beakjoon.bronze;

import java.util.Scanner;

public class Q2711 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int cnt = sc.nextInt() - 1;
			sb.setLength(0);
			sb.append(sc.next());

			sb.deleteCharAt(cnt);
			System.out.println(sb.toString());
		}
	}
}
