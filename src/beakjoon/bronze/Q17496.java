package beakjoon.bronze;

import java.util.Scanner;

public class Q17496 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt() - 1;
		int T = sc.nextInt();
		int C = sc.nextInt();
		int P = sc.nextInt();

		int cnt = N / T;
		System.out.println(cnt * C * P);
	}
}
