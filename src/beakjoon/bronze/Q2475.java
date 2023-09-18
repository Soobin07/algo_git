package beakjoon.bronze;

import java.util.Scanner;

public class Q2475 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//각 수의 제곱한 수의 합을 10으로 나눈 나머지
		int ans = 0;
		for(int i = 0 ; i < 5 ; i++) {
			ans += Math.pow(sc.nextInt(), 2);
		}
		System.out.println((int)ans%10);
	}
}
