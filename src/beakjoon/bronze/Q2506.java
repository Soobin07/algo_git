package beakjoon.bronze;

import java.util.Scanner;

public class Q2506 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int ans = 0;
		int con = 0;
		for (int i = 0; i < N; i++) {
			int tmp = sc.nextInt();
			if (tmp == 0) {
				con = 0;
			} else {
				con++;
				ans += con;
			}
		}

		System.out.println(ans);
	}
}
