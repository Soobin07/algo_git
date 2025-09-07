package beakjoon.bronze;

import java.util.Arrays;
import java.util.Scanner;

public class Q11948 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr1 = new int[4];
		for (int i = 0; i < 4; i++) {
			arr1[i] = sc.nextInt();
		}
		int[] arr2 = new int[2];
		for (int i = 0; i < 2; i++) {
			arr2[i] = sc.nextInt();
		}

		Arrays.sort(arr1);
		Arrays.sort(arr2);

		int sum = 0;
		for (int i = 0; i < 3; i++) {
			sum += arr1[3 - i];
		}
		sum += arr2[1];

		System.out.println(sum);
	}
}
