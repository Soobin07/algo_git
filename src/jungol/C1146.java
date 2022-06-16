package jungol;

import java.util.Arrays;
import java.util.Scanner;

public class C1146 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i = 0 ; i < N-1 ; i++) {
			int idx = i;	//최소값의 idx
			for(int j = i ; j < N ; j++) {	//정렬되지 않은 값들 확인
				if(arr[idx] > arr[j]) {	//최소값을 찾으면
					idx = j;
				}
			}
			int tmp = arr[i];
			arr[i] = arr[idx];
			arr[idx] = tmp;
			
			System.out.println(Arrays.toString(arr).replace("]", "").replace("[", "").replace(", ", " "));
		}
	}
}
