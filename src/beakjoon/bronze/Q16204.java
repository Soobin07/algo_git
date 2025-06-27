package beakjoon.bronze;

import java.util.Scanner;

public class Q16204 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // N개의카드
		int M = sc.nextInt(); // M개의 O
		int K = sc.nextInt(); // 새로 적을 O

		System.out.println(Math.min(M, K) + Math.min(N - M, N - K));
	}
}
