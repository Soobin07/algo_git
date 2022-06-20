package jungol;

import java.util.Scanner;

//https://pomase.tistory.com/24

public class C1836_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];	
		
		for(int i = 0 ; i < N ; i++) {
			arr[i] = sc.nextInt();
		}	//arr 채우기
		
		int max = -100000;	//max값 가장 작게 초기화
		int tmp = 0;	//임시로 연속합 구하는 값
		for(int i = 0 ; i < N ; i++) {	
			tmp += arr[i];	//임시 연속값에 더하기
			if(max < tmp) max = tmp;	//만약 tmp가 max보다 크면 max에 tmp 넣기
			if(tmp < 0) tmp = 0;	//0보다 작아지면 다음 숫자부터 다시 더하기
		}
		
		System.out.println(max);
	}
}
