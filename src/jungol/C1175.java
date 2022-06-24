package jungol;

import java.util.Scanner;

public class C1175 {
	static int M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		M = sc.nextInt();
		
		comb(0, 0, new int[N]);
	}
	public static void comb(int sidx, int sum, int[] selected) {
		if(sidx == selected.length) {
			if(sum == M) {
				for(int i = 0 ; i < selected.length ; i++) {
					System.out.print(selected[i]+" ");
				}
				System.out.println();
			}
			return;
		}
		for(int i = 1 ; i <= 6 ; i++) {
			selected[sidx] = i;
			comb(sidx+1, sum+i, selected);
		}
	}
	
}
