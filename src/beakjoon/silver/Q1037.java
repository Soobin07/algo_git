package beakjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

public class Q1037 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		long ans = arr[0]*arr[arr.length-1];
		System.out.println(ans);
	}
}
