package jungol;

import java.util.Scanner;

//시간초과..다시볼것
public class C1836 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];	
		int[] sum = new int[N];	//해당 값까지 더한 값
		
		arr[0] = sum[0] = sc.nextInt();
		int max = arr[0];
		
		for(int i = 1 ; i < N ; i++) {
			arr[i] = sc.nextInt();	// 배열 넣기
			sum[i] = sum[i-1] + arr[i];	//합 넣기(처음부터 i까지)
			
			for(int j = 0 ; j < i ; j++) {	//비교하기 (j부터 i까지)
				max = Math.max(max, sum[i]-sum[j]);
			}
			max = Math.max(max, sum[i]);
			max = Math.max(max, arr[i]);
		} 
		System.out.println(max);
	}
}
