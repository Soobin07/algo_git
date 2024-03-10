package beakjoon.bronze;

import java.util.Scanner;

//상금 헌터
public class Q15953 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr1 = new int[] { 0, 500, 300, 300, 200, 200, 200, 50, 50, 50, 50, 30, 30, 30, 30, 30, 10, 10, 10, 10,
				10, 10 };
		int[] arr2 = new int[] { 0, 512, 256, 256, 128, 128, 128, 128, 64, 64, 64, 64, 64, 64, 64, 64, 32, 32, 32, 32,
				32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };

		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			long sum = 0;
			int score1 = sc.nextInt();
			int score2 = sc.nextInt();

			if (score1 < arr1.length) {
				sum += arr1[score1];
			}
			if (score2 < arr2.length) {
				sum += arr2[score2];
			}

			System.out.println(sum * 10000);
		}
	}
}
