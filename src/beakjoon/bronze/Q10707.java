package beakjoon.bronze;

import java.util.Scanner;

//수도요금
public class Q10707 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		int Y = sc.nextInt();
		int C = sc.nextInt();
		int D = sc.nextInt();
		int P = sc.nextInt();

		long sumX = P * X;
		long sumY = 0;
		if (P <= C)
			sumY = Y;
		else
			sumY = (P - C) * D + Y;

		System.out.println(Math.min(sumX, sumY));
	}
}
