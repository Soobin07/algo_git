package beakjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

public class Q14729 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		double[] chil = new double[7];
		Arrays.fill(chil, 101D);

		for (int i = 0; i < N; i++) {
			double now = sc.nextDouble();
			if (chil[6] > now) {
				chil[6] = now;
				Arrays.sort(chil);
			}
		}

		for (int i = 0; i < 7; i++) {
			System.out.printf("%.3f\n", chil[i]);
		}
	}
}
