package beakjoon.bronze;

import java.util.Scanner;

public class Q1929 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		for(int i = n ; i <= m ; i++) {
			if(isPrime(i)) sb.append(i).append("\n");
		}

		System.out.println(sb.toString());
	}
	static boolean isPrime(int num) {
		if(num < 2) return false;
		for(int i = 2 ; i*i <= num ; i++) {	
			//i*i로 나누어 떨어지는 수는 i로 나누어 떨어진다.//큰 수의 소수를 찾을 때 유용할듯
			if(num % i == 0) return false;
		}
		return true;
	}
}
