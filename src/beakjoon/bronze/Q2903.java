package beakjoon.bronze;

import java.util.Scanner;

//중앙 이동 알고리즘
public class Q2903 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		System.out.println((int) Math.pow((Math.pow(2, N) + 1), 2));
	}
}
