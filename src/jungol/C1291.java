package jungol;

import java.util.Scanner;

public class C1291 {
	public static void main(String[] args) {
		//구간 처음과 끝을 입력받는다
		//입력 구간 범위는 증가/감소 순서 그대로 출력
		
		Scanner sc = new Scanner(System.in);
		//input error
		int s = 0;
		int e = 0;
		while(true) {			
			s = sc.nextInt();
			e = sc.nextInt();
			if(s >= 2 && s <= 9 && e >= 2 && e <= 9)
				break;
			else
				System.out.println("INPUT ERROR!");
		}
		
		
		
		//s e 크기에 따라 나누어 출력
		if(s <= e) {
			for(int j = 1 ; j <= 9 ; j++) {
				for(int i = s ; i <= e ; i++) {
					System.out.printf("%d * %d = %2d   ", i, j, i*j);
				}
				System.out.println();
			}			
		}else {
			for(int j = 1 ; j <= 9 ; j++) {
				for(int i = s ; i >= e ; i--) {
					System.out.printf("%d * %d = %2d   ", i, j, i*j);
				}
				System.out.println();
			}			
		}
	}
}
