package jungol;

import java.util.Arrays;
import java.util.Scanner;

public class C1158 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = sc.nextInt();
		}//입력
		
		for(int i = 1 ; i < arr.length ; i++) {
			int key = arr[i];
			int j;
			for(j = i-1 ; j>=0 && arr[j] > key ; j--) {
				arr[j+1]= arr[j];
			}
			arr[j+1] = key;
			
			System.out.println(Arrays.toString(arr).replace("]", "").replace("[", "").replace(", ", " "));
		}
	}
}
