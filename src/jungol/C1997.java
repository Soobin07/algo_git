package jungol;

import java.util.Scanner;

public class C1997 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int D = sc.nextInt();
		int K = sc.nextInt();
		
		int[][] cnt = new int[D][2];
		cnt[0][1] = cnt[1][0] = 0;
		cnt[0][0] = cnt[1][1] = 1;
		
		for(int i = 2 ; i < D ; i++) {
			cnt[i][0] = cnt[i-1][1];
			cnt[i][1] = cnt[i-1][0]+cnt[i-1][1];
		}
		
		outer : for(int i = 1 ; i <= 100000 ; i++) {
			for(int j = i ; j <= 100000 ; j++) {
				int tmp = cnt[D-1][0]*i + cnt[D-1][1]*j;
				if(tmp == K) {
					System.out.println(i);
					System.out.println(j);
					break outer;
				}else if( tmp > K) continue outer;
			}
		}
	}
}
