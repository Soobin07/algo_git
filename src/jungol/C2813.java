package jungol;

import java.util.Scanner;

public class C2813 {
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
		
		int count = 0;
		for(int i = M ; i < N+1 ; i++) {
			if(!primes[i]) {
				count++;
			}
		}
		System.out.println(count);
	}
}
