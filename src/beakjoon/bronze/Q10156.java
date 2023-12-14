package beakjoon.bronze;

import java.util.Scanner;

public class Q10156 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt(); // 과자 한개의 가격
		int N = sc.nextInt(); // 사려고 하는 과자 갯수
		int M = sc.nextInt(); // 현재 가진 돈

		// 부모님께 받아야 하는 돈의 액수
		int need = K * N; // 필요한 돈
		if (M - need >= 0) {
			System.out.println(0);
		} else {
			System.out.println(Math.abs(M - need));
		}
	}
}
