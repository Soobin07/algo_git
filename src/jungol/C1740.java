package jungol;

import java.util.Scanner;

public class C1740 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		boolean[] primes = new boolean[N+1];	//true : 소수아님, false : 소수
		primes[0] = primes[1] = true;
		for(int i = 2 ; i*i <= N ; i++) {
			if(!primes[i]) {//아직 소수인 경우에만 확인
				for(int j = i ; j*i <= N ; j++) {
					primes[j*i] = true;
				}
			}
		}
		
		int sum = 0;
		int min = N;
		for(int i = M ; i < N+1 ; i++) {
			if(!primes[i]) {
				min = Math.min(min, i);
				sum += i;
			}
		}
		if(sum != 0) {
			System.out.println(sum);
			System.out.println(min);
		}else {
			System.out.println(-1);
		}
	}
}
