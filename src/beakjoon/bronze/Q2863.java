package beakjoon.bronze;

import java.util.Scanner;

public class Q2863 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[2][2];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		double max = cul(arr);
		int idx = 0;

		for (int i = 1; i < 4; i++) {
			change(arr);
			double val = cul(arr);
			if (val - max > 1e-9) {
				max = val;
				idx = i;
			}
		}

		System.out.println(idx);
	}

	public static void change(int[][] arr) {
		int a = arr[0][0];
		int b = arr[0][1];
		int c = arr[1][0];
		int d = arr[1][1];

		arr[0][0] = c;
		arr[0][1] = a;
		arr[1][0] = d;
		arr[1][1] = b;
	}

	public static double cul(int[][] arr) {
		return 1D * arr[0][0] / arr[1][0] + 1D * arr[0][1] / arr[1][1];
	}
}
