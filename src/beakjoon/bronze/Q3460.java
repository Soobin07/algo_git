package beakjoon.bronze;

import java.util.Scanner;

//이진수
public class Q3460 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();

		int T = sc.nextInt();
		while (T-- > 0) {
			sb.setLength(0);
			int N = sc.nextInt();

			int idx = 0;
			while (N > 0) {
				if (N % 2 == 1) {
					sb.append(idx + " ");
				}
				idx++;
				N = (N - (N % 2)) / 2;
			}

			System.out.println(sb.toString());
		}
	}
}
