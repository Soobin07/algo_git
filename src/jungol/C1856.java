package jungol;

import java.util.Scanner;

public class C1856 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		//왼>오, 오>왼
		
		for(int i = 0 ; i < n ; i++) {
			if(i % 2 == 0) {				
				for(int j = 1 ; j <= m ; j++) {
					System.out.print(i*m+j+" ");
				}
			}else {
				for(int j = m ; j >= 1 ; j--) {
					System.out.print(i*m+j+" ");
				}
			}
			System.out.println();
		}
	}
}
