package beakjoon.silver;

import java.util.Scanner;

public class Q13301 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		if(N == 1) System.out.println(4);
		else {
			long[] around = new long[N];	// (둘레길이)
			
			//초기값
			around[0] = 4;	//사각형 한개일때 둘레 4
			around[1] = 6;	//사각형 두개일 때 둘레 6
			
			for(int i = 2 ; i < N ; i++) {
				around[i] = around[i-1]+around[i-2];
			}
			
			System.out.println(around[N-1]);
		}
	}
}
