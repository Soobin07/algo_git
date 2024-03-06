package beakjoon.silver;

import java.util.Scanner;

//초콜릿 식사
public class Q2885 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		// 상근이가 먹을 최소 양
		int K = sc.nextInt();

		// 2진수로 바꾸면 몇자리인지 알 수 있다
		String k_str = Integer.toBinaryString(K);
		// 가장 끝의 1 있는 곳 -> 그만큼 잘라야 함
		int cnt = k_str.lastIndexOf('1');

		// k가 제곱수라면?
		if (cnt == 0) {
			System.out.println(K + " " + 0);
		} else {
			System.out.println((int) Math.pow(2, k_str.length()) + " " + (cnt + 1));
		}
	}
}
