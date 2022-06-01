package beakjoon.bronze;

import java.util.Arrays;
import java.util.Scanner;

public class Q2751 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n ; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		for(int i = 0 ; i < n ; i++) {
			sb.append(arr[i]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
