package beakjoon.silver;

import java.util.Scanner;

public class Q3135 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();

		// 즐겨찾기 버튼
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int min = Math.abs(A - B);
		for (int i = 0; i < N; i++) {
			min = Math.min(min, Math.abs(arr[i] - B) + 1);
		}
		
		System.out.println(min);
	}
}
