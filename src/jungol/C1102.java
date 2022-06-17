package jungol;

import java.util.Scanner;

public class C1102 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];	//가장 크게
		int arr_idx = 0;
		
		for(int i = 0 ; i < N ; i++) {
			char next = sc.next().charAt(0);
			switch(next) {
				case 'i' :
					arr[arr_idx++] = sc.nextInt();
					break;
				case 'o' :
					if(arr_idx == 0) System.out.println("empty");
					else {
						arr_idx--;
						System.out.println(arr[arr_idx]);
					}
					break;
				case 'c' :
					System.out.println(arr_idx);
					break;
			}
		}
	}
}
