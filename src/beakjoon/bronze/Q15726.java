package beakjoon.bronze;

import java.util.Scanner;

//이칙연산
public class Q15726 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double A = sc.nextInt();
		double B = sc.nextInt();
		double C = sc.nextInt();
		double ans = A * Math.max(B, C) / Math.min(B, C);
		System.out.println((int) ans);
	}
}
