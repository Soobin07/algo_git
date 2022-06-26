package jungol;

import java.util.Scanner;

public class C2567 {
	static int[] res;
	static int N, P;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		P = sc.nextInt();
		res = new int[P];
		
		res(N, P);
		
		int cnt = 0;
		for(int i = 0 ; i < res.length ; i++) {
			if(res[i] >= 2) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	public static void res(int n, int p) {
		n *= N;
		n %= p;
		res[n]++;
		if(res[n] >= 3) return;
		res(n, p);
	}
}
