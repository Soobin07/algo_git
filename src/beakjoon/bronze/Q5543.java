package beakjoon.bronze;

import java.util.Scanner;

public class Q5543 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 가장 싼 메뉴의 가격을 출력
		int[] burger = { sc.nextInt(), sc.nextInt(), sc.nextInt() };
		int[] vever = { sc.nextInt(), sc.nextInt() };

		int ans = 10000;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				int tmp = burger[i] + vever[j];
				ans = Math.min(ans, tmp - 50);
			}
		}
		System.out.println(ans);
	}
}
