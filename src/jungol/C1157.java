package jungol;

import java.util.Arrays;
import java.util.Scanner;

public class C1157 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i = 0 ; i < N-1 ; i++) {	//몇번?
			for(int j = 1 ; j < N-i ; j++) {
				if(arr[j] < arr[j-1]) {
					int tmp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = tmp;
				}
			}
			System.out.println(Arrays.toString(arr).replace("]", "").replace("[", "").replace(", ", " "));
		}
	}
}
