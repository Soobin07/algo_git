package jungol;

import java.util.Scanner;

public class C1341 {
	public static void main(String[] args) {
		// 구구단 범위 입력받아 해당 구간 구구단 출력
		// 출력 처음과 끝단 받는다 (순서는 입력받은대로)
		
		//모든 값과 부호 사이는 공백으로 구분
		//식과 식 사이는 3개 공백, 구구단 사이에는 한줄
		
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		int e = sc.nextInt();
		
		if(s <= e) {
			for(int i = s ; i <= e ; i++) {
				for(int j = 1 ; j <= 9 ; j++) {
					System.out.printf("%d * %d = %2d   ", i, j, i*j);
					if(j % 3 == 0) {
						System.out.println();
					}
				}
				System.out.println();
			}
		}else {
			for(int i = s ; i >= e ; i--) {
				for(int j = 1 ; j <= 9 ; j++) {
					System.out.printf("%d * %d = %2d   ", i, j, i*j);
					if(j % 3 == 0) {
						System.out.println();
					}
				}
				System.out.println();
			}
			
		}
	}
}
