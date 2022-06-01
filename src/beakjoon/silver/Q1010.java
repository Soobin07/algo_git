package beakjoon.silver;

import java.util.Scanner;

//시간초과
public class Q1010 {
	static int ans = 0;
	static int N;
	static int M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1 ; t <= T ; t++) {
			ans = 0;
			N = sc.nextInt();
			M = sc.nextInt();
			
			can(0, 0);
			
			System.out.println(ans);
		}
	}
	
	//n : 현재 N의 인덱스, 얘가 갈 M을 결정하는 것
	//m : 이전 N의 인덱스가 결정한 다리+1. 여기서부터 볼 수 있다
	static void can(int n, int m) {
		if(m > M) return; //없는 다리에 연결하래
		if(M-m < N-n) return;	//다 해도 부족
		if(n == N) {	//다함. 종료
			ans++;
			return; 
		}
		for(int i = m ; i < M ; i++) {
			can(n+1, i+1);
		}
	}
}
