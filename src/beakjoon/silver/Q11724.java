package beakjoon.silver;

import java.util.Scanner;

public class Q11724 {
	static int[] p;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		p = new int[N+1];
		//부모 만들기
		for(int i = 1 ; i <= N ; i++) {
			p[i] = i;
		}
		
		//간선 받기
		for(int i = 0 ; i < M ; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			p[findSet(ed)] = findSet(st);
		}
		
		int ans = 0;
		for(int i = 1 ; i <= N ; i++) {
			if(p[i] == i) ans++;
		}
		System.out.println(ans);
	}
	static int findSet(int x) {
		if(x == p[x]) return x;
		return p[x] = findSet(p[x]);
	}
}
