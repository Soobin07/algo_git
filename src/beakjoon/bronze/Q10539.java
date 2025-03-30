package beakjoon.bronze;

import java.util.Arrays;
import java.util.Scanner;

public class Q10539 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] B = new int[N];
		for (int i = 0; i < N; i++) {
			B[i] = sc.nextInt();
		}
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = B[i] * (i + 1);
		}
		int sum = A[0];
		for (int i = 1; i < N; i++) {
			A[i] -= sum;
			sum += A[i];
		}

		System.out.println(Arrays.toString(A).replaceAll("[\\[\\]\\,]", ""));
	}
}
