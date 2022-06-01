package jungol;

import java.util.Scanner;

public class C1304 {
	public static void main(String[] args) {
		//n 받은 후 정사각형 출력
		//위>아래, 왼>오
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i = 1 ; i <= n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				System.out.print(n*j+i+" ");
			}
			System.out.println();
		}
	}
}
