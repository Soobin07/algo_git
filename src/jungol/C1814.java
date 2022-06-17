package jungol;

import java.util.Scanner;

public class C1814 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = sc.nextInt();
		}
		
		int cnt = 0;
		for(int i = 1 ; i < N ; i++) {
			int key = arr[i];
			int j = i-1;
			for(j = i-1; j >= 0 && arr[j] > key ; j--) {
				arr[j+1] = arr[j];
				cnt++;
			}
			arr[j+1] = key;
		}
		
		System.out.println(cnt);
	}
}
