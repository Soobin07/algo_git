package beakjoon.bronze;

import java.util.Scanner;

//꼬리를 무는 숫자 나열
public class Q1598 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt() - 1;
		int B = sc.nextInt() - 1;

		System.out.println(Math.abs(A / 4 - B / 4) + Math.abs(A % 4 - B % 4));
	}
}
