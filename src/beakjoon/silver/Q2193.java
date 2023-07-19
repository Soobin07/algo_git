package beakjoon.silver;

import java.util.Scanner;

public class Q2193 {
	static long[] number;
	public static void main(String[] args) throws Exception {
		//이친수 1. 0으로 시작 X, 2. 1이 연속 두번 X
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		number = new long[N+1];
		
		number[0] = 0;
		number[1] = 1;
		//N자리 이친수의 개수를 구하는 프로그램
		//make(1, 1);
		
		/*
		 * N = 1 => 1
		 * N = 2 => 1
		 * N = 3 => 2
		 * N = 4 => 3
		 * ... 피보나치
		 */
		
		for(int i = 2 ; i < N+1 ; i++) {
			number[i] = number[i-1] + number[i-2];
		}
		
		System.out.println(number[N]);
	}
	// 90일 경우 상당히 오래걸림
	/*
	static void make(int index, int before) {
		if(index == number.length) {
			cnt++;
			return;
		}
		
		if(before == 0) {
			for(int i = 0 ; i < 2 ; i++) {
				number[index] = i;
				make(index+1, i);
			}
		}else {
			number[index] = 0;
			make(index+1, 0);
		}
	}
	*/
}
