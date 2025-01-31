package beakjoon.silver;

import java.util.Scanner;

public class Q9507 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();

		long[] arr = new long[68];
		arr[0] = 1;
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;
		for (int n = 4; n < arr.length; n++) {
			arr[n] = arr[n - 1] + arr[n - 2] + arr[n - 3] + arr[n - 4];
		}

		for (int tc = 0; tc < TC; tc++) {
			int n = sc.nextInt();
			System.out.println(arr[n]);
		}
	}
}
