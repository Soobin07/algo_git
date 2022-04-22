package beakjoon.gold;

import java.util.Scanner;
//range minimum query
//를 공부하여
//Segement Tree
//를 사용하여야만 풀 수 있다고 하였다
public class Q2357 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];
		int start, end, max, min;
		
		for(int i = 0 ; i < n ; i++ ) {
			arr[i] = sc.nextInt();
		}
		
		for(int i = 0 ; i < m ; i++) {
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			
			start = sc.nextInt()-1;
			end = sc.nextInt();
			for(int j = start ; j < end ; j++) {
				if(arr[j] > max) max = arr[j];
				if(arr[j] < min) min = arr[j];
			}
			sb.append(min).append(" ").append(max).append("\n");
		}
		System.out.println(sb.toString());
	}
}
