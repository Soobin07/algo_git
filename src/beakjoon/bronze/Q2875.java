package beakjoon.bronze;

import java.util.Scanner;

public class Q2875 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		
		int max = 0;
		//인턴쉽 가는 여자 숫자
		for(int i = 0 ; i <= K ; i++) {
			int g = N - i;
			int b = M - (K - i);
			
			int team = Math.min(g/2, b);
			
			max = Math.max(team, max);
		}
		System.out.println(max);
	}
}
