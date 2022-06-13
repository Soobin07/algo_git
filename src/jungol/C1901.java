package jungol;

import java.util.Scanner;

public class C1901 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		//1000000이하 정수들 중 소수를 모은다
		boolean[] primes = new boolean[1000001];	//true : 소수아님, false : 소수
		primes[0] = primes[1] = true;
		for(int i = 2 ; i*i <= 1000000 ; i++) {
			if(!primes[i]) {//아직 소수인 경우에만 확인
				for(int j = i ; j*i <= 1000000 ; j++) {
					primes[j*i] = true;
				}
			}
		}
		
		for(int i = 0 ; i < N ; i++) {
			int num = sc.nextInt();
			
			//본인이 소수면 본인 출력 후 넘어간다
			if(!primes[num]) {
				System.out.println(num);
				continue;
			}
			
			//본인이 소수가 아닌 경우
			for(int j = 1 ; j < num ; j++) {
				if(!primes[num-j]) {
					System.out.print(num-j+" ");
				}
				if(!primes[num+j]) {
					System.out.print(num+j+" ");
				}
				if(!primes[num-j] || !primes[num+j]) {
					System.out.println();
					break;
				}
			}
		}
		
	}
}
