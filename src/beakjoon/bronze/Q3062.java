package beakjoon.bronze;

import java.util.Scanner;

public class Q3062 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			StringBuffer sb = new StringBuffer();
			sb.append(str);

			sb.reverse();

			int sum = Integer.parseInt(str) + Integer.parseInt(sb.toString());
			sb.setLength(0);
			sb.append(sum);

			String A = sb.toString();
			sb.reverse();
			String B = sb.toString();

			if (A.equals(B)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
