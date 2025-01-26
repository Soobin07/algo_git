package beakjoon.bronze;

import java.util.Scanner;

public class Q1173 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int m = sc.nextInt();
		int M = sc.nextInt();
		int T = sc.nextInt();
		int R = sc.nextInt();
		
		if(M - m < T) {
			System.out.println(-1);
		}else {
			int cnt = 0;
			int p = 0;
			int n = m;
			while(true) {
				cnt++;
				if(n + T <= M) {
					p++;
					n += T;
				}else if(n - R <= m) {
					n = m;
				}else {
					n -= R;
				}
				
				if(p == N) {
					break;
				}
			}
			System.out.println(cnt);
		}
	}
}
