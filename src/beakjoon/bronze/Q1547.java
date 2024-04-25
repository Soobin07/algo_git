package beakjoon.bronze;

import java.util.Scanner;

//공
public class Q1547 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		// 1번에 공
		int N = sc.nextInt();

		int now = 1;
		for (int i = 0; i < N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			if (a == now) {
				now = b;
			} else if (b == now) {
				now = a;
			}
		}
		
		System.out.println(now);
	}
}
