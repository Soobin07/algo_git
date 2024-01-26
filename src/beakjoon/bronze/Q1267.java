package beakjoon.bronze;

import java.util.Scanner;

//핸드폰 요금
public class Q1267 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int sum1 = 0;
		int sum2 = 0;

		for (int i = 0; i < N; i++) {
			double tmp = sc.nextInt() + 1;

			sum1 += Math.ceil(tmp / 30.0) * 10;
			sum2 += Math.ceil(tmp / 60.0) * 15;
		}

		if (sum1 < sum2) {
			System.out.println("Y " + sum1);
		} else if (sum1 > sum2) {
			System.out.println("M " + sum2);
		} else {
			System.out.println("Y M " + sum1);
		}
	}
}
