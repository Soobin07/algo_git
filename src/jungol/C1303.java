package jungol;

import java.util.Scanner;

public class C1303 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		//왼>오
		
		for(int i = 0 ; i < n ; i++) {
			for(int j = 1 ; j <= m ; j++) {
				System.out.print(i*m+j+" ");
			}
			System.out.println();
		}
	}
}
